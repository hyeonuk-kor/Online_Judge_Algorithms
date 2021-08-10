console.log(solution(1500, [1200,1300,1400,1500]));
function solution(k, rates) {
    var buyday = 0;
    var sellday = 0;
    for(var day = 0; day<rates.length; day++) {
        var min = rates[day];
        for(buyday = day+1; buyday<rates.length; buyday++) {
            if(min>rates[buyday]) {
                min = rates[buyday];
            } else {
                break;
            }
        }
        day = buyday;
        if(day==rates.length)
            break;
        k -= min;
        var max = rates[day];
        for(sellday = day+1; sellday<rates.length; sellday++) {
            if(max<rates[sellday]) {
                max = rates[sellday];
            } else {
                break;
            }
        }
        day = sellday-1;
        k += max;
    }
    return k;
}