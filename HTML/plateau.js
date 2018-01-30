var figure1= '1,1,1/1,0,0';
var figure1_90='1,1/0,1/0,1';

function ajouterPiece(str){
var arrayOfStrings1 =str.split('/');
var tetri=$('<div/>');
tetri.addClass('tetri');
tetri.addClass('current');
$('div.plateau').append(tetri);
for(var i=0;i<arrayOfStrings1.length;i++){
  arraysOfStrings2=arrayOfStrings1[i].split(',');
  var ligne=$('<div/>');
  ligne.addClass('ligne');
  tetri.append(ligne);
  for(var j=0; j<arraysOfStrings2.length;j++){
    var str1 =arraysOfStrings2[j];
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
}
ajouterPiece(figure1);

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
                if(document.querySelector('div.current').offsetLeft>00){
                    $('div.current').css({"left": "-=50px"},'fast');
                }

            break;
            case arrow.right:
              if(document.querySelector('div.current').offsetLeft <$('div.plateaucomplet').width()-$('div.current').width()){
                $('div.current').css({"left": "+=50px"},'fast');
              }
            break;
            case arrow.down:
              if(document.querySelector('div.current').offsetTop <$('div.plateaucomplet').height()-$('div.current').height()){
                $('div.current').css({"bottom": "-=50px"},'fast');
              }
            break;
            case arrow.up:
              var left =document.querySelector('div.current').offsetLeft;
              var top =document.querySelector('div.current').offsetTop;

              $('div.current').addClass('none')

              $('div.current').removeClass('current');
              $('div.tetri').replaceWith(ajouterPiece(figure1_90));


              $('div.current').css({"left": "+="+left+"px"},'fast');
              $('div.current').css({"bottom": "-="+top+"px"},'fast');

        }
    });
});
