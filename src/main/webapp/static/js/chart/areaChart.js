var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
    type: 'line',
  data: {
    labels: ["2014", "2015", "2016", "2017", "2018", "2019", "2020"],
    datasets: [{
      label: "Time",
      lineTension: 0.3,
      borderColor: "#4e73df",
      pointRadius: 2.5,
      pointBackgroundColor: "#4e73df",
      pointBorderColor: "#4e73df",
      pointHoverRadius: 3,
      pointHoverBackgroundColor: "#4e73df",
      pointHoverBorderColor: "#4e73df",
      pointHitRadius: 10,
      pointBorderWidth: 2,
      data: [10000, 5000, 1000, 15000, 25000, 40000, 8000],
    }],
  },
  options: {
    maintainAspectRatio: false,
    layout: {
      padding: {
        left: 10,
        right: 15,
        top: 15,
        bottom: 0
      }
    },
    scales: {
        xAxes: [{
          gridLines: {
            display: false,
          },
        }],
        yAxes: [{
          ticks: {
            maxTicksLimit: 5,
            padding: 10,
          },
          gridLines: {
            color: "#eaecf4",
            zeroLineColor: "#eaecf4",
            drawBorder: false,
            borderDash: [5],
            zeroLineBorderDash: [5]
          }
        }],
      },
      legend: {
        display: false
      },
    tooltips: {
        backgroundColor: "#ffffff",
        bodyFontColor: "#858796",
        titleMarginBottom: 10,
        titleFontColor: '#6e707e',
        titleFontSize: 14,
        borderColor: '#dddfeb',
        borderWidth: 1,
        xPadding: 15,
        yPadding: 15,
        displayColors: false,
        intersect: false,
        mode: 'index',
        caretPadding: 10,
    }
  }
})