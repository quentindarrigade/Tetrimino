function TetrisNext(tetris, nbNexts) {
	var that = this;

	this.tetriminos = [];


	/*
	 * Créer un nouveau tetrimino à suivre
	 */
	this.createTetrimino = function() {
		var myTetrimino = tetris.createTetrimino();
		var myClonedTetrimino = myTetrimino.clone(); //On clone le tetrimino pour le modifier sans scrupule
		var myFigure = tetris.getFigure(myTetrimino); //On récupère quelques informations
		var myNext = $('<div class="next" />');

		//On modifie un peu le tetrimino en lui donnant une hauteur et une largeur
		myClonedTetrimino.width(myFigure.l * myFigure.sizeOfBloc);
		myClonedTetrimino.height(myFigure.h * myFigure.sizeOfBloc);
		myNext.append(myClonedTetrimino);

		this.tetriminos.push({
			concrete: myTetrimino, //Le vrai tetrimino
			virtual: myNext //La copie, celle qu'on utilise dans la zone "à suivre"
		});
	};



	/*
	 * Récupérer et jouer le tetrimino suivant
	 */
	this.apply = function() {
		var myTetrimino = this.tetriminos.splice(0, 1)[0]; //On dépile le premier tetrimino
		var myNextTetriminos = []; //On prépare la nouvelle liste des tetriminos à suivre

		//On applique le tetrimino qui suit, et on en crée un nouveau qu'on manage ici
		tetris.apply(myTetrimino.concrete);
		this.createTetrimino();

		//On fait une nouvelle liste avec uniquement les clones, le reste n'est pas intéressant
		for (let tetrimino of this.tetriminos) {
			myNextTetriminos.push(tetrimino.virtual);
		}

		//On informe que la nouvelle liste des suivants est prête
		$(this).trigger('nextUpdated', [ myNextTetriminos ]);

		return myTetrimino.concrete;
	};



	/*
	 * On génère les n tetriminos au chargement du plugin
	 */
	if (!nbNexts || nbNexts < 0) nbNexts = 1;
	for (let i = 0; i < nbNexts; i++) {
		this.createTetrimino();
	}
}
