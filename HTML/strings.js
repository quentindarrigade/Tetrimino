var tetriminos = [
    //O
	{
        nom: 'O',
		couleur: '#FDD835',
		figures: [
			{
				string: "1,1/1,1"
			}
		]
	},


    //I
	{
        nom: 'I',
		couleur: '#039BE5',
		figures: [
			{
				string: "1/1/1/1"
			},
			{
				string: "1,1,1,1"
			}
		]
	},


    //T
	{
        nom: 'T',
		couleur: '#D81B60',
		figures: [
			{
				string: "0,1,0/1,1,1"
			},
			{
				string: "1,0/1,1/1,0"
			},
			{
				string: "1,1,1/0,1,0"
			},
			{
				string: "0,1/1,1/0,1"
			}
		]
	}
];



//On converti les strings en matrices
for (let tetrimino of tetriminos) {
	for (let figure of tetrimino.figures) {
		figure.matrice = [];

		var myRows = figure.string.split("/");
		for (let i = 0; i < myRows.length; i++) {
			figure.matrice.push(myRows[i].split(","));
		}
	};
};
