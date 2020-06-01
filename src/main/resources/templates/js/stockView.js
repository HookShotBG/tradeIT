var app = new Vue({
    el: '#app',
    data: {
        user: {
            name: 'Luke',
            lastName: 'Skywalker'
        },


        },
    methods: {
        sayHello: function () {
            alert("Hello " + this.user.name)
        }
    } })