function TetrisGhost(tetris) {
	var that = this;

	this.ghostTetrimino = null; //Fantôme
	this.tetris = tetris;
	this.tetriPosition = null; //Position du fantôme



	/*
	 * Mettre à jour le fantôme
	 */
	this.update = function() {
		//Si un fantôme existe, on le supprime
		if (this.ghostTetrimino) {
			this.ghostTetrimino.remove();
		}

		//On clone le tetrimino en cours, on lui ajoute la classe
		this.ghostTetrimino = this.tetris.tetrimino.clone();
		this.ghostTetrimino.addClass('ghost');

		//On indique à ceux qui nous écoute qu'on a créé un fantôme
		$(this).trigger('ghostCreated', [ this.ghostTetrimino ]);


		var myFigure = this.tetris.getFigure();

		//On place le fantôme à la première position jouable (en partant du bas de la grille)
		for (var y = this.tetris.boardGrid.length - 1; y >= 0; y--) {
			this.tetriPosition = { y: (y - myFigure.h + 1), x: this.tetris.tetriPosition.x };

			if (this.tetris.isPlayable(this.tetriPosition)) {
				this.ghostTetrimino.css('top', (this.tetriPosition.y * this.tetris.sizeOfBloc) + 'px');
				break;
			}
		}

		this.ghostTetrimino.css('left', (this.tetris.tetriPosition.x * this.tetris.sizeOfBloc) + 'px');
	};



	/*
	 * Placer le tetrimino
	 */
	this.put = function() {
		this.tetris.hit(this.tetriPosition); //On joue le tetrimino à la position du fantôme
		this.tetris.moveToBottom(); //On force le placement du tetrimino
	};



	/*
	 * Interception d'un coup joué
	 */
	$(this.tetris).on('hitPlayed', function() {
		//On se met à jour quand le tetrimino change de position
		that.update();
	});
}
