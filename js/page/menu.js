const Menu = (function () {

    const menu_open_class = 'menu-open',
          toggler_active_class = 'toggler-active';

    return {
        initialize: function () {
            let toggler = $('.toggler'),
                menu = $('.menu'),
                edit_profile = $('#edit-profile');

            // Open menu
            toggler.click(function () {
                menu.toggleClass(menu_open_class);
                toggler.toggleClass(toggler_active_class);
            });

            // If 'Change salary' was requested, open the dialog
            edit_profile.click(function () {
                Cookie.clean();
                Navigation.to_entry();
            });
        },
    }
}());

$(document).ready(function () {
    Menu.initialize();

    let date = new Date();
    let seconds = date.getSeconds();
    let minutes = date.getMinutes();
    let hours = date.getHours();

    initClocks(hours, minutes, seconds);
    moveSecondHands();
    setUpMinuteHands();
});

function initClocks(hours, minutes, seconds) {
    let hands = [
        {
            hand: 'hours',
            angle: (hours * 30) + (minutes / 2)
        },
        {
            hand: 'minutes',
            angle: (minutes * 6)
        },
        {
            hand: 'seconds',
            angle: (seconds * 6)
        }
    ];
    for (let j = 0; j < hands.length; j++) {
        let elements = document.querySelectorAll('.' + hands[j].hand);
        for (let k = 0; k < elements.length; k++) {
            elements[k].style.webkitTransform = 'rotateZ('+ hands[j].angle +'deg)';
            elements[k].style.transform = 'rotateZ('+ hands[j].angle +'deg)';
            if (hands[j].hand === 'minutes') {
                elements[k].parentNode.setAttribute('data-second-angle', hands[j + 1].angle);
            }
        }
    }
}

function setUpMinuteHands() {
    let containers = document.querySelectorAll('.minutes-container');
    let secondAngle = containers[containers.length - 1].getAttribute('data-second-angle');
    if (secondAngle > 0) {
        let delay = (((360 - secondAngle) / 6) + 0.1) * 1000;
        setTimeout(function() {
            moveMinuteHands(containers);
        }, delay);
    }
}

function moveMinuteHands(containers) {
    for (let i = 0; i < containers.length; i++) {
        containers[i].style.webkitTransform = 'rotateZ(6deg)';
        containers[i].style.transform = 'rotateZ(6deg)';
    }
    setInterval(function() {
        for (let i = 0; i < containers.length; i++) {
            if (containers[i].angle === undefined) {
                containers[i].angle = 12;
            } else {
                containers[i].angle += 6;
            }
            containers[i].style.webkitTransform = 'rotateZ('+ containers[i].angle +'deg)';
            containers[i].style.transform = 'rotateZ('+ containers[i].angle +'deg)';
        }
    }, 60 * 1000);
}


function moveSecondHands() {
    let containers = document.querySelectorAll('.seconds-container');
    setInterval(function() {
        for (let i = 0; i < containers.length; i++) {
            if (containers[i].angle === undefined) {
                containers[i].angle = 6;
            } else {
                containers[i].angle += 6;
            }
            containers[i].style.webkitTransform = 'rotateZ('+ containers[i].angle +'deg)';
            containers[i].style.transform = 'rotateZ('+ containers[i].angle +'deg)';
        }
    }, 1000);
}

