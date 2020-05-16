let ctx = document.getElementById('myBarChart').getContext('2d');
let myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["2014", "2015", "2016", "2017", "2018", "2019", "2020"],
        datasets: [{
            data: [10000, 20000, 30000, 40000, 50000, 60000, 70000],
            backgroundColor: "#4e73df",
            borderColor: "#4e73df",
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            xAxes: [{
                gridLines: {
                    display: false,
                },
            }],
            yAxes: [{
                ticks: {
                    beginAtZero: true
                },
                gridLines: {
                    color: "#eaecf4",
                    zeroLineColor: "#eaecf4",
                    drawBorder: false,
                    borderDash: [5],
                    zeroLineBorderDash: [5]
                }
            }]
        },
        legend: {
            display: false
        },
        tooltips: {
            titleMarginBottom: 10,
            titleFontColor: '#6e707e',
            titleFontSize: 14,
            backgroundColor: "#ffffff",
            bodyFontColor: "#858796",
            borderColor: '#dddfeb',
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: false,
            caretPadding: 10,
        }
    }
})