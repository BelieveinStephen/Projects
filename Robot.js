function main(){
    var data = document.getElementById('routein').value;
    var heading = 'W';
    var directions = (get_directions(data));
    var headings = (get_heading(directions, heading));
    var moves = (get_move(directions));
    var cardinals_c = (move(headings, moves));
    var ans = (optimizer(cardinals_c));
    var set = (set_instructions(ans));
    var re = (display(data, set));
    alert(re);

}

function get_directions(data){
    var routes = data.split("; ");
    routes = routes[2];
    routes = routes.split(', ');
    return routes;
}

function get_heading(directions, heading){
    heading_l = [];
    for(var instruction of directions){
        if (instruction.indexOf('L') > -1){
            heading = (turn_left(heading));
            heading_l.push(heading);
        }
        else {
            heading = (turn_right(heading));
            heading_l.push(heading);
        }
    }
    return heading_l;
}

function turn_left(heading){
    if (heading == 'W') {
        heading = 'S';
	}
	else if (heading == 'S') {
	    heading = 'E';
	}
	else if (heading == 'N') {
	    heading = 'W';
	}
	else {
	    heading = 'N';
	}
	return heading;
}

function turn_right(heading){
    if (heading == 'W') {
        heading = 'N';
	}
	else if (heading == 'S') {
	    heading = 'W';
	}
	else if (heading == 'N') {
	    heading = 'E';
	}
	else {
	    heading = 'S';
	}
	return heading;
}

function get_move(directions){
    var moves = [];
    for(instruction of directions){
        let temp = instruction;
        let count = temp.replace(/\D/g, "");
        moves.push(count);
    }
    return moves;
}

function move(headings, moves){
    var cardinals_c = [0, 0, 0, 0];
    var i;
    for(i = 0; i < headings.length; i++){
        let temp = parseInt(moves[i]);
        let temp_h = headings[i];
        if (temp_h == 'W') {
		    cardinals_c[3] += temp;
	    }
	    else if (temp_h == 'E') {
		    cardinals_c[1] += temp;
	    }
        else if (temp_h == 'N') {
            cardinals_c[0] += temp;
        }
        else {
            cardinals_c[2] += temp;
        }
    }
    return cardinals_c;
}

function optimizer(cardinals_c){
    ans = [];
    var coor_x = cardinals_c[1] - cardinals_c[3];
    ans.push(coor_x);
    var coor_y = cardinals_c[0] - cardinals_c[2];
    ans.push(coor_y);
    return ans;
}

function set_instructions(ans){
    var x = ans[0];
    var y = ans[1];
    var re = '';
    if (y < 0 && x < 0) {
        y = Math.abs(y);
        x = Math.abs(x);
        re = 'L' + y + ', R' + x;
	}
	else if (y > 0 && x > 0) {
		y = 'R' + y;
		re = y + ", R" + x;
	}
	else if (y > 0 && x < 0) {
	    y = 'R' + y;
		re = y + ", L" + Math.abs(x);
    }
    else if (y < 0 && x > 0) {
        y = 'L' + Math.abs(y);
        re = y + ', L' + x;
    }
	else if (x == 0 && y > 0){
	    re = 'R' + y;
    }
    else if (x == 0 && y < 0){
        re = 'L' + Math.abs(y);
    }
    else if (y == 0 && x > 0) {
		re = 'R0,' + ' R' + x ;
	}
	else if (y == 0 && x == 0) {
		re = 'No optimal path';
	}
	return re;
}

function display(data, set){
    data = data.split(';');
    data[2] = set;
    data = data.join("; ");
    return data;

}