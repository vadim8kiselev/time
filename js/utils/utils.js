function time_from_seconds(raw_seconds) {

    let years_in_seconds = Constant.year_in_seconds();
    let day_in_seconds = Constant.day_in_seconds();
    let hours_in_seconds = Constant.hours_in_seconds();
    let minutes_in_seconds = Constant.minutes_in_seconds();

    raw_seconds = Math.round(raw_seconds);

    let time = '';

    if ((raw_seconds / years_in_seconds) >= 1) {
        let years = Math.floor(raw_seconds / years_in_seconds);
        time += years_to_time(years);
        raw_seconds %= years * years_in_seconds;
    }

    if ((raw_seconds / day_in_seconds) >= 1) {
        let days = Math.floor(raw_seconds / day_in_seconds);
        time += days_to_time(days);
        raw_seconds %= days * day_in_seconds;
    }

    if ((raw_seconds / hours_in_seconds) >= 1) {
        let hours = Math.floor(raw_seconds / hours_in_seconds);
        time += hours_to_time(hours);
        raw_seconds %= hours * hours_in_seconds;
    }

    if ((raw_seconds / minutes_in_seconds) >= 1) {
        let minutes = Math.floor(raw_seconds / minutes_in_seconds);
        time += minutes_to_time(minutes);

        raw_seconds %= minutes * minutes_in_seconds;
    }

    if (raw_seconds > 0) {
        time += seconds_to_time(raw_seconds);
    }

    if (time === '') {
        time = '0 seconds'; // ?
    }

    return $.trim(time);
}

function years_to_time(years) {
    return years + ' year' + plural(years);
}

function days_to_time(days) {
    return days + ' day' + plural(days);
}

function hours_to_time(hours) {
    return hours + ' hour' + plural(hours);
}

function minutes_to_time(minutes) {
    return minutes + ' minute' + plural(minutes);
}

function seconds_to_time(seconds) {
    return seconds + ' second' + plural(seconds);
}

function plural(number) {
    return number !== 1 ? 's ' : ' ';
}