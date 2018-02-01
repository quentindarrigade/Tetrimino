var plateau=[
[0,0,0,0,1,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0]
];
var x=0;
var y=0;

var figure1= {f00:'1,1,1/1,0,0',
f90: '1,1/0,1/0,1',
f180:'0,0,1/1,1,1',
f270: '1,0/1,0/1,1'}

var figure2= {f00:'1,1,0/0,1,1',
f90: '0,1/1,1/1,0',
f180:'1,1,0/0,1,1',
f270: '0,1/1,1/1,0'}
// var figure1_90='1,1/0,1/0,1';
// var figure2= '1,1,0/0,1,1';
// var figure2_90= '0,1/1,1/1,0';
var figure3= {f00:'1,1,1,1',
f90: '1/1/1/1',
f180:'1,1,1,1',
f270: '1/1/1/1'}
// var figure3= '1,1,1,1';
// var figure3_90= '1/1/1/1';
var figure4= {f00:'1,1/1,1',
f90: '1,1/1,1',
f180:'1,1/1,1',
f270: '1,1/1,1'}
// var figure4= '1,1/1,1';
// var figure4_90= '1,1/1,1';

var compteur=0;
var tetriMatrix=new Array();

function ajouterPiece(figure){
var tab = [];
tab= [figure.f00,figure.f90,figure.f180,figure.f270];
var arrayLigne =tab[compteur].split('/');
var tetri=$('<div/>');
tetri.addClass('tetri');
tetri.addClass('current');
tetri.data('name',figure);
tetri.attr('compteur', compteur);
$('div.plateau').append(tetri);
for(var i=0;i<arrayLigne.length;i++){
  var arrayColonne=arrayLigne[i].split(',');
  tetriMatrix.push(arrayColonne);
  var ligne=$('<div/>');
  ligne.addClass('ligne');
  tetri.append(ligne);
  for(var j=0; j<arrayColonne.length;j++){
    var str1 =arrayColonne[j];
    var case1 = $('<div/>');
    ligne.append(case1);
    if (str1==1) {
      case1.addClass('poule');
    }
    if (str1==0){
      case1.addClass('vide');
    }


  }
};
movePlateau();
}
ajouterPiece(figure2);
console.log(tetriMatrix);
function movePlateau(){
  for (var j =0; j<tetriMatrix.length;j++){
    for (var i=0; i<tetriMatrix[j].length-1;i++){
          plateau[j+x][i+y]=parseInt(tetriMatrix[j][i]);
      }
    if(plateau[j+x][tetriMatrix[j].length+y]!=1){
      plateau[j+x][tetriMatrix[j].length+y-1]=parseInt(tetriMatrix[j][tetriMatrix[j].length]);
    }

    }

  }


console.log(plateau);

// aleatoire();

function ajouterPiece2(figure){
var tab = [];
tab= [figure.f00,figure.f90,figure.f180,figure.f270];
var arrayOfStrings1 =tab[compteur].split('/');
var tetri=$('<div/>');
tetri.addClass('tetri');
tetri.addClass('prochaine');
tetri.data('name',figure);
tetri.attr('compteur', compteur);
$('div.piecesuivante').append(tetri);
for(var i=0;i<arrayOfStrings1.length;i++){
  arraysOfStrings2=arrayOfStrings1[i].split(',');
  var ligne=$('<div/>');
  ligne.addClass('ligne2');
  tetri.append(ligne);
  for(var j=0; j<arraysOfStrings2.length;j++){
    var str1 =arraysOfStrings2[j];
    var case1 = $('<div/>');
    ligne.append(case1);
    if (str1==1) {
      case1.addClass('poule2');
    }
    if (str1==0){
      case1.addClass('vide2');
    }


  }
};
}

var tab = document.querySelectorAll('div.ligne');
console.log(tab);
var ligne=tab[tab.length-1];
console.log(typeof ligne);

var top2 =ligne.offsetTop;

console.log(top2  );




$(document).ready(function(){
    $(document).keydown(function (e) {
        var keyCode = e.keyCode || e.which,
        arrow = {left: 37, up: 38, right: 39, down: 40 };

        switch (keyCode) {
            case arrow.left:
                if(document.querySelector('div.current').offsetLeft>=50){
                    $('div.current').css({"left": "-=50px"},'fast');

                }

            break;
            case arrow.right:
              if(document.querySelector('div.current').offsetLeft <$('div.plateau').width()-$('div.current').width()){

                var bool=true;
                for (var i=0; i<tetriMatrix.length;i++){
                  if(plateau[i+x][tetriMatrix[i].length+y]==1 && plateau[i+x][tetriMatrix[i].length+y-1]==1){
                    bool=false;
                  }
              }
              if(bool==true){
                y+=1;
                movePlateau();
                $('div.current').css({"left": "+=50px"},'fast');

                for(var i =0;i<tetriMatrix.length;i++){
                  plateau[i+x][y-1]=0;
                }
              }

              }
            break;
            case arrow.down:
              if(document.querySelector('div.current').offsetTop <$('div.plateau').height()-$('div.current').height()){
                $('div.current').css({"bottom": "-=50px"},'fast');
              }
            break;
            case arrow.up:
              var left =document.querySelector('div.current').offsetLeft;
              var top =document.querySelector('div.current').offsetTop;

              var name = $('div.current').data('name');
              var compteur1=$('div.current').attr('compteur');

              if(compteur1==0){
                if($('div.current')[0].offsetLeft==($('div.plateau')[0].offsetWidth-$('div.current')[0].offsetWidth)
                && ($('div.current')[0].offsetHeight>$('div.current')[0].offsetWidth)) {
                  var diff=$('div.current')[0].offsetHeight-$('div.current')[0].offsetWidth;
                  $('div.current').css({"left": "-="+diff+"px"},'fast');
                  compteur=1;
                  $('div.current').replaceWith(ajouterPiece(name));


                }
                else  {
                  compteur=1;
                  $('div.current').replaceWith(ajouterPiece(name));
                  $('div.current')[0].offsetLeft=left;
                  $('div.current')[0].offsetTop=top;
                }
              }
              else if(compteur1==1) {

                if($('div.current')[0].offsetLeft==($('div.plateau')[0].offsetWidth-$('div.current')[0].offsetWidth)
                && ($('div.current')[0].offsetHeight>$('div.current')[0].offsetWidth)) {
                  var diff=$('div.current')[0].offsetHeight-$('div.current')[0].offsetWidth;
                  compteur=2;
                  $('div.current').replaceWith(ajouterPiece(name));
                  $('div.current').css({"left": "-="+diff+"px"},'fast');

                }
                else  {
                  compteur=2;
                  $('div.current').replaceWith(ajouterPiece(name));
                  $('div.current')[0].offsetLeft=left;
                  $('div.current')[0].offsetTop=top;
                }
              }
              else if(compteur1==2) {

                if($('div.current')[0].offsetLeft==($('div.plateau')[0].offsetWidth-$('div.current')[0].offsetWidth)
                && ($('div.current')[0].offsetHeight>$('div.current')[0].offsetWidth)) {
                  var diff=$('div.current')[0].offsetHeight-$('div.current')[0].offsetWidth;
                  compteur=3;
                  $('div.current').replaceWith(ajouterPiece(name));
                  $('div.current').css({"left": "-="+diff+"px"},'fast');

                }
                else  {
                  compteur=3;
                  $('div.current').replaceWith(ajouterPiece(name));
                  $('div.current')[0].offsetLeft=left;
                  $('div.current')[0].offsetTop=top;
                }
              }

              else if(compteur1==3) {

                if($('div.current')[0].offsetLeft==($('div.plateau')[0].offsetWidth-$('div.current')[0].offsetWidth)
                && ($('div.current')[0].offsetHeight>$('div.current')[0].offsetWidth)) {
                  var diff=$('div.current')[0].offsetHeight-$('div.current')[0].offsetWidth;
                  compteur=0;
                  $('div.current').replaceWith(ajouterPiece(name));
                  $('div.current').css({"left": "-="+diff+"px"},'fast');

                }
                else  {
                  compteur=0;
                  $('div.current').replaceWith(ajouterPiece(name));
                  $('div.current')[0].offsetLeft=left;
                  $('div.current')[0].offsetTop=top;
                }
              }



              $('div.current').css({"left": "+="+left+"px"},'fast');
              $('div.current').css({"bottom": "-="+top+"px"},'fast');
              var diff=$('div.plateau').height()-$('div.current').height()-document.querySelector('div.current').offsetTop;
              if(document.querySelector('div.current').offsetTop>$('div.plateau').height()-$('div.current').height()){
                $('div.current').css({"top": "+="+diff+"px"},'fast');
              }


        }
    });
});

// var compteur2=0;
// window.onload = function()
// {
//   setInterval(function()
//   {
//     if(document.querySelector('div.current').offsetTop <$('div.plateaucomplet').height()-$('div.current').height()){
//       $('div.current').css({"bottom": "-=50px"},'fast');
//     }
//     else {
//       $('div.current').removeClass('current');
//       var name2=$('div.prochaine').data('name');
//       ajouterPiece($('div.prochaine').data('name'));
//       aleatoire();
//       compteur2++;
//       console.log(compteur); }
//   }, 1000);
// }
// function aleatoire() {
//   var chiffre= Math.floor((Math.random() * 4  ) + 1);
//   switch (chiffre) {
//     case 1: $('div.prochaine').replaceWith(ajouterPiece2(figure1)); break;
//     case 2: $('div.prochaine').replaceWith(ajouterPiece2(figure2)); break;
//     case 3: $('div.prochaine').replaceWith(ajouterPiece2(figure3)); break;
//     case 4: $('div.prochaine').replaceWith(ajouterPiece2(figure4)); break;
//   }
// }
