(function() {
	try {
		var myRemovedTimeoutAnimationDuration = 250;
		var myTetris = new Tetris({
			hauteur: 14,
			largeur: 8,
			sizeOfBloc: 50,
			tetriminos: tetriminos
		});

		//On charge tetrisAuto, tetrisGhost, tetrisScore et tetrisNext s'ils sont disponibles
		try { var myTetrisAuto = new TetrisAuto(myTetris, 1000); } catch (e) { };
		try { var myTetrisGhost = new TetrisGhost(myTetris); } catch (e) { };
		try { var myTetrisScore = new TetrisScore(myTetris); } catch (e) { };
		try { var myTetrisNext = new TetrisNext(myTetris, 1); } catch (e) { };
	}

	catch (e) {
		alert(e);
		return;
	};




	/*
	 * Lance un nouveau tetrimino
	 * Ce n'est pas Tetris qui gère les suivants
	 */
	function pull() {
		$('.plateau').append( //On ajoute au plateau le tetrimino
			(myTetrisNext) ? //Si le tetrimino "à suivre" est actif
				myTetrisNext.apply() : //On applique le tetrimino à suivre
				myTetris.apply() //Sinon, on demande d'appliquer un nouveau tetrimino
		);

		//Si le fantôme est actif
		if (myTetrisGhost) myTetrisGhost.update();

		//Si le tetris automatisé est actif
		if (myTetrisAuto) myTetrisAuto.start((myTetrisScore) ? (1000 / myTetrisScore.level) : 1000);
	}



	/*
	 * Interception des touches
	 */
	$(document).on('keydown', function(e) {
		var isPrevent = true;

		switch (e.which || e.keyCode) {
			case 13: myTetris.pause(); break;
			case 37: myTetris.moveToLeft(); break;
			case 38: myTetris.changeFigure(); break;
			case 39: myTetris.moveToRight(); break;
			case 40: myTetris.moveToBottom(); break;
			case 32: if (myTetrisGhost) myTetrisGhost.put(); break;
			default: isPrevent = false; break;
		}

		//Si prevent est actif, on empêche le comportement du navigateur par défaut de s'exécuter
		if (isPrevent) {
			e.preventDefault();
		}
	});



	/*
	 * Interception d'un coup joué
	 */
	$(myTetris).on('hitPlayed', function(e, hit) {
		hit.tetrimino.css('top', (hit.y * hit.sizeOfBloc) + 'px');
		hit.tetrimino.css('left', (hit.x * hit.sizeOfBloc) + 'px');
	});





	/*
	 * Interception d'un tetrimino placé
	 */
	$(myTetris).on('tetriminoPut', function(e, tetrimino, sizeOfBloc, blocPositions) {
		//Pour chaque bloc du tetrimino
		for (let blocPosition of blocPositions) {
			//On clone un bloc
			var myBloc = tetrimino.find('.bloc:nth-child(1)').clone();

			//On sauvegarde sur quelle ligne il est positionné
			myBloc.attr('data-ligne', blocPosition.y);

			//On récupère sa position sur le plateau (top et left) et sa couleur
			myBloc.css('background', tetrimino.find('.bloc:nth-child(1)').css('background'));
			myBloc.css('top', (blocPosition.y * sizeOfBloc));
			myBloc.css('left', (blocPosition.x * sizeOfBloc));

			//On le place sur le plateau
			$('.plateau').append(myBloc);
		};

		//On supprime le tetrimino (et ses blocs par conséquent !)
		$('.plateau .tetrimino').remove();

		//On relance un nouveau coup
		pull();
	});



	/*
	 * Interception d'une (ou plusieurs) ligne(s) complétée(s)
	 */
	$(myTetris).on('rowsCompleted', function(e, sizeOfBloc, completedRows) {
		//A tous les blocs à supprimer, on leur ajoute la classe "removing"
		completedRows.forEach(function(row) {
			$('.bloc[data-ligne="' + row + '"]').addClass('removing');
		});


		//On applique un laps de temps avant de supprimer, pour l'effet visuel
		setTimeout(function() {
			//On supprime chaque ligne à supprimer
			for (let row of completedRows) {
				$('.bloc[data-ligne="' + row + '"]').remove(); //Paf, ligne supprimée

				//On oublie pas d'incrémenter l'index des lignes des blocs restant (on a supprimé une ligne !)
				for (var i = row + 1; i > 0; i--) {
					//On récupère les blocs de la ligne d'avant
					$('.bloc[data-ligne="' + (i - 1) + '"]').each(function() {
						$(this).attr('data-ligne', i); //On donne le nouvel indice
						$(this).css('top', (i * sizeOfBloc)); //Et puis on le déplace visuellement !
					});
				}
			};

			//On force la mise à jour du fantôme, si le plugin est actif
			if (myTetrisGhost) myTetrisGhost.update();
		}, myRemovedTimeoutAnimationDuration);
	});



	/*
	 * Interception de la pause
	 */
	$(myTetris).on('paused', function(e, paused) {
		console.log((paused) ? "TETRIS EN PAUSE" : "REPRISE DU TETRIS");
	});



	/*
	 * Interception d'un Game Over
	 */
	$(myTetris).on('gameOver', function() {
		console.log("GAME OVER :'(");
	});



	/*
	 * Interception d'un fantôme créé
	 */
	if (myTetrisGhost) {
		$(myTetrisGhost).on('ghostCreated', function(e, ghost) {
			//On ajoute le fantôme au plateau
			$('.plateau').append(this.ghostTetrimino);
		});
	}


	/*
	 * Interception d'une modification du score
	 */
	if (myTetrisScore) {
		$(myTetrisScore).on('scoring', function() {
			//On change les scores sur le tableau des scores
			$('.livescore .score').html(myTetrisScore.points);
		});
	}


	/*
	 * Interception de la nouvelle liste du ou des tetrimino(s) à suivre
	 */
	if (myTetrisNext) {
		$(myTetrisNext).on('nextUpdated', function(e, nextTetriminos) {
			$('.livescore > .piecesuivante').children().remove();

			for (let next of nextTetriminos) {
				$('.livescore > .piecesuivante').append(next);
			}
		});
	}


	//On démarre le jeu au démarrage directement après le chargement de la page
	pull();
})();
