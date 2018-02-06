function TetrisAuto(tetris, defaultDuration) {
	if (defaultDuration === undefined) defaultDuration = 1000;

	var that = this;
	this.autoTetris = null; //Intervale
	this.defaultDuration = defaultDuration; //Durée d'attente par défaut avant de jouer un coup


	/*
	 * Démarrer l'automatisation vers le bas du tetrimino
	 */
	this.start = function(duration) {
		if (duration === undefined) duration = this.defaultDuration;

		clearInterval(this.autoTetris); //Arrêt de l'intervale
		this.autoTetris = setInterval(function() { //Démarrage de l'intervale
			tetris.moveToBottom();
		}, duration);
	};



	/*
	 * Interception d'un Game Over
	 */
	$(tetris).on('gameOver', function() {
		//On arrête l'intervale quand la partie est terminée
		clearInterval(that.autoTetris);
	});
};
