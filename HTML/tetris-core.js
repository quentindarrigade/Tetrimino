function Tetris(options) {
	if (options === undefined) options = { };

	//Avant tout, la liste des tetriminos
	if (options.tetriminos === undefined) {
		//Même pas un tetrimino, pas la peine d'aller plus loin ...
		throw new Error("Impossible de lancer la partie : aucun tétrimino");
	}

	//Autres options, valeurs par défaut
	if (options.largeur === undefined) options.largeur = 8;
	if (options.hauteur === undefined) options.hauteur = 14;
	if (options.sizeOfBloc === undefined) options.sizeOfBloc = 50;

	if (options.tetriminoClassName === undefined) options.tetriminoClassName = 'tetrimino';
	if (options.blocClassName === undefined) options.blocClassName = 'bloc';


	//Attributs
	this.tetriminos = options.tetriminos; //Liste des tetriminos et de leurs figures
	this.sizeOfBloc = options.sizeOfBloc; //Taille d'un bloc d'un tetrimino
	this.tetriminoClassName = options.tetriminoClassName; //Nom de la classe d'un tetrimino
	this.blocClassName = options.blocClassName; //Nom de la classe d'un bloc d'un tetrimino

	this.tetrimino = null; //Le tetrimino en cours
	this.tetriPosition = { }; //La position du tetrimino en cours
	this.boardGrid = []; //La grille de jeu
	this.isPaused = false; //Variable qui permet de mettre le jeu en pause
	this.isOver = false; //Variable qui permet de définir si le jeu est terminé

	//On génère la grille
	for (let y = 0; y < options.hauteur; y++) {
		this.boardGrid[y] = [];

		for (let x = 0; x < options.largeur; x++) {
			this.boardGrid[y][x] = 0;
		}
	}

	//On calcul une position initiale idéale par tetrimino (pour le centrer sur la grille au début)
	for (let tetrimino of this.tetriminos) {
		tetrimino.initX = Math.ceil((options.largeur - tetrimino.figures[0].matrice[0].length) / 2);
	}



	/*
	 * Créer un tetrimino
	 */
	this.createTetrimino = function() {
		//On récupère un tetrimino au hasard parmis ceux qui sont disponibles
		var mySelectedTetrimino = this.tetriminos[Math.floor(Math.random() * this.tetriminos.length)];

		//On génère la div tetrimino
		//L'attribut data-figure est utilisé pour indiquer quelle figure (rotation) est en cours d'utilisation
		var myTetrimino = $('<div class="' + this.tetriminoClassName + '" data-figure="0" />');

		//On enregistre tout le tetrimino dans les données, ainsi que ses figures (pour raccourci)
		myTetrimino.data('source', mySelectedTetrimino);
		myTetrimino.data('figures', mySelectedTetrimino.figures);

		//On dessine la première figure du tetrimino sélectionné
		this.drawFigure(myTetrimino, mySelectedTetrimino.figures[0]);

		return myTetrimino;
	};



	/*
	 * Activer un tetrimino
	 */
	this.apply = function(tetrimino) {
		//Si on demande pas d'appliquer un tetrimino en particulier, on en génére un et on l'applique
		this.tetrimino = (tetrimino === undefined) ? this.createTetrimino() : tetrimino;

		//On réinitialise la position du tetrimino
		this.tetriPosition = { y: 0, x: this.tetrimino.data('source').initX };
		this.hit(this.tetriPosition);

		return this.tetrimino;
	};



	/*
	 * Dessiner la figure en blocs HTML
	 */
	this.drawFigure = function(tetrimino, figure) {
		//On supprime tous les blocs
		tetrimino.children().remove();

		//Pour chaque bloc de la figure
		for (var y = 0; y < figure.matrice.length; y++) {
			for (var x = 0; x < figure.matrice[y].length; x++) {
				if (figure.matrice[y][x] == 1) {
					//On génère la div bloc
					var myBloc = $('<div class="' + this.blocClassName + '" />');

					//On défini ses propriétés CSS (couleur, position top et left)
					// myBloc.css('background-color', tetrimino.data('source').couleu);
					myBloc.css('top', this.sizeOfBloc * y);
					myBloc.css('left', this.sizeOfBloc * x);

					//On ajoute la div bloc au tetrimino
					tetrimino.append(myBloc);
				}
			}
		}
	};




	/*
	 * Se déplacer à gauche
	 */
	this.moveToLeft = function() {
		this.hit({ y: this.tetriPosition.y, x: this.tetriPosition.x - 1 });
	};




	/*
	 * Se déplacer à droite
	 */
	this.moveToRight = function() {
		this.hit({ y: this.tetriPosition.y, x: this.tetriPosition.x + 1 });
	};




	/*
	 * Se déplacer en bas
	 */
	this.moveToBottom = function() {
		//Si hit() retourne false, le coup n'a pas pu se faire, il faut placer le tetrimino
		if (!this.hit({ y: this.tetriPosition.y + 1, x: this.tetriPosition.x })) {
			this.put();
		}
	};




	/*
	 * Changement de figure (rotation)
	 */
	this.changeFigure = function() {
		if ((!this.isPaused) && (!this.isOver)) {
			//On récupère le nombre maximum de figures
			var myFiguresCount = this.tetrimino.data('figures').length - 1;

			//On incrémente la figure si on a pas atteint le maximum
			if (parseInt(this.tetrimino.attr('data-figure')) < myFiguresCount) {
				this.tetrimino.attr('data-figure', parseInt(this.tetrimino.attr('data-figure')) + 1);
			}

			//Sinon on repart à 0
			else {
				this.tetrimino.attr('data-figure', 0);
			}


			//On dessine la nouvelle figure
			this.drawFigure(this.tetrimino, this.tetrimino.data('figures')[this.tetrimino.attr('data-figure')]);


			//On cherche la position possible de la nouvelle figure du tetrimino en partant de la position actuelle
			//Et tant qu'on ne l'a pas trouvé, on se déplace virtuellement
			//Evite les collisions à la rotation contre les bordures et contre les blocs posés
			for (var y = this.tetriPosition.y; y >= 0; y--) {
				var isOK = false;

				for (var x = this.tetriPosition.x; x >= 0; x--) {
					//Si on peut jouer, on peut quitter la boucle : on a trouvé la position idéale jouable
					if (this.hit({ y: y, x: x })) {
						isOK = true;
						break;
					}
				}

				//Si on peut jouer, on peut quitter la boucle : on a trouvé la position idéale jouable
				if (isOK) {
					break;
				}
			}
		}
	};





	/*
	 * Récupérer la matrice de la figure du tetrimino en cours, et quelques autres infos
	 * On retourne la matrice, sa hauteur et sa largeur
	 */
	this.getFigure = function(tetrimino) {
		if (tetrimino === undefined) tetrimino = this.tetrimino;

		var myFigures = tetrimino.data('figures');
		var myFigure = myFigures[parseInt(tetrimino.attr('data-figure'))];

		//On retourne le résultat
		return {
			figure: myFigure.matrice,
			h: myFigure.matrice.length,
			l: myFigure.matrice[0].length,
			sizeOfBloc: this.sizeOfBloc
		};
	};







	/*
	 * Tester si le coup est jouable
	 */
	this.isPlayable = function(tetriPosition) {
		var myFigure = this.getFigure();


		//On vérifie si on peut jouer ce coup
		for (var y = tetriPosition.y; y < (tetriPosition.y + myFigure.h); y++) {
			for (var x = tetriPosition.x; x < (tetriPosition.x + myFigure.l); x++) {
				if ((!this.boardGrid[y]) || ((this.boardGrid[y][x] != 0) && (myFigure.figure[y - tetriPosition.y][x - tetriPosition.x] != 0))) {
					//On ne peut pas jouer - on a dépassé le tableau ou tout n'est pas disponible (des 1 sont présents)
					return false;
				}
			}
		}

		return true;
	};





	/*
	 * Jouer un coup (déplacer le tetrimino sur la grille)
	 */
	this.hit = function(tetriPosition) {
		if ((!this.isPaused) && (!this.isOver)) {
			var isPlayable = this.isPlayable(tetriPosition);


			//Si on peut jouer ce coup, alors on y va !
			if (this.isPlayable(tetriPosition)) {
				this.tetriPosition.x = tetriPosition.x;
				this.tetriPosition.y = tetriPosition.y;

				//On indique à ceux qui nous écoute qu'on a joué !
				$(this).trigger('hitPlayed', [ { //On envoie le tetrimino, la position et la taille d'un bloc
					tetrimino: this.tetrimino,
					y: this.tetriPosition.y,
					x: this.tetriPosition.x,
					sizeOfBloc: this.sizeOfBloc
				} ]);
			}

			return isPlayable;
		}
	};







	/*
	 * Placer le tetrimino sur la grille
	 */
	this.put = function() {
		if ((!this.isPaused) && (!this.isOver)) {
			var myFigure = this.getFigure();
			var myBlocPositions = [];
			var isGameOver = false;


			//Pour chaque case de la matrice à partir de la position du tetrimino
			for (var y = this.tetriPosition.y; y < this.tetriPosition.y + myFigure.h; y++) {
				for (var x = this.tetriPosition.x; x < this.tetriPosition.x + myFigure.l; x++) {
					//Si c'est libre
					if ((this.boardGrid[y]) && (this.boardGrid[y][x] == 0)) {
						this.boardGrid[y][x] = myFigure.figure[y - this.tetriPosition.y][x - this.tetriPosition.x];

						//Si on a un bloc à cette position
						if (this.boardGrid[y][x] > 0) {
							//On ajoute à la liste sa position sur la grille
							myBlocPositions.push({ y: y, x: x });
						}
					}

					//Si c'est pas libre, c'est game over
					else if (y == 0) {
						isGameOver = true;
						break;
					}
				}

				//Si game over, pas la peine d'aller plus loin
				if (isGameOver) break;
			}


			//Si pas game over
			if (!isGameOver) {
				//On informe que le tetrimino a été posé, et on vérifie s'il y a des lignes complétées !
				$(this).trigger('tetriminoPut', [ this.tetrimino, this.sizeOfBloc, myBlocPositions ]);
				this.checkCompletedRows();
			}

			//Sinon ...
			else {
				//On informe du Game Over ... c'est TER-MI-NE !
				this.isOver = true;
				$(this).trigger('gameOver');
			}
		}
	};




	/*
	 * Vérifier les lignes complétées
	 */
	this.checkCompletedRows = function() {
		var isRowCompleted = true;
		var completedRows = [];

		//On parcours toute la grille (il peut y avoir plusieurs lignes, et pas toutes en bas ...)
		for (var y = 0; y < this.boardGrid.length; y++) {
			var isRowCompleted = true;

			for (var x = 0; x < this.boardGrid[y].length; x++) {
				if (this.boardGrid[y][x] == 0) {
					isRowCompleted = false;
					break;
				}
			}

			//Si la ligne est complète, on l'ajoute à la liste des lignes complétées
			if (isRowCompleted) {
				completedRows.push(y);
			}
		}

		//On informe des lignes complétées
		$(this).trigger('rowsCompleted', [ this.sizeOfBloc, completedRows ]);

		//Pour chaque ligne complétée
		for (var i = 0; i < completedRows.length; i++) {
			//On la supprime de la grille (on se retrouve avec une ligne en moins)
			this.boardGrid.splice(completedRows[i], 1);

			//On insère une nouvelle ligne vierge, tout en haut (parce qu'il nous en manque une)
			var myRow = [];
			for (var x = 0; x < this.boardGrid[0].length; x++) {
				myRow[x] = 0;
			}

			this.boardGrid.splice(0, 0, myRow);
		}
	};




	/*
	 * Mettre en pause
	 */
	this.pause = function() {
		this.isPaused = !this.isPaused;

		//On informe qu'on a mis en pause (ou qu'on a repri)
		$(this).trigger('paused', [ this.isPaused ]);
	}
};
