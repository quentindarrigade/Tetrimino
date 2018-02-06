function TetrisScore(tetris) {
	var that = this;

	this.points = 0;
	this.lines = 0;
	this.level = 1;




	/*
	 * Marquer des points avec un nombre de lignes
	 */
	this.score = function(nbRows) {
		if (nbRows && nbRows > 0) {
			this.lines += nbRows; //On ajoute le nombre de lignes complétées

			//Points en fonction du nombre de lignes et du niveau
			switch (nbRows) {
				case 1: this.points += 40 * (this.level + 1); break;
				case 2: this.points += 100 * (this.level + 1); break;
				case 3: this.points += 300 * (this.level + 1); break;
				case 4: this.points += 1200 * (this.level + 1); break;
			}

			//Toutes les 10 lignes, on incrémente le niveau
			if (this.lines % 10 == 0) {
				this.level++;
			}

			//On informe du scoring
			$(this).trigger('scoring');
		}
	};



	/*
	 * Interception d'une (ou plusieurs) ligne(s) complétée(s)
	 */
	$(tetris).on('rowsCompleted', function(e, sizeOfBloc, completedRows) {
		//On applique le score avec le nombre de lignes brisées
		that.score(completedRows.length);
	});
}
