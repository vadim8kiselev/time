let ctx = document.getElementById("myPieChart").getContext('2d');
let myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
     labels: ["2014", "2015", "2016", "2017", "2018", "2019", "2020"],
    datasets: [{
        data:[10000,20000,30000,40000,50000,60000, 70000],
        backgroundColor: ['#4e73df', '#1e90ff', '#36b9cc', '#000080', '#87ceeb','#4682b4','#4169e1'],
        hoverBackgroundColor: '#17a673',
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});