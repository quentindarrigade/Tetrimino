var figure1= '1,1,1/1,0,0';
var figure1_90='1,1/0,1/0,1';
function ajouterPiece(str){
var arrayOfStrings1 =str.split('/');
var tetri=$('<div/>');
tetri.addClass('tetri');
$('div[class="plateau"]').append(tetri);
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
ajouterPiece(figure1);
