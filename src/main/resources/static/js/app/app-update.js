new Vue({
    el: '#main-container',
    data: {
        appVersion: {}
    },
    methods: {
        doUpdate: function () {
            axios({
                url: '/manager/app/saveOrUpdate',
                method: 'POST',
                data: this.appVersion
            }).then(response => {
                //通过父窗口layer对象弹框
                parent.layer.msg(response.data.msg);
                //先得到当前iframe层的索引
                let index = parent.layer.getFrameIndex(window.name);
                //通过父窗口layer对象执行关闭，关闭当前子窗口
                parent.layer.close(index);
            }).catch(function (error) {
                layer.msg(error.message)
            })
        },
        toClose: function () {
            //先得到当前iframe层的索引
            let index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        }
    },
    created: function () {
        this.appVersion = parent.layer.appVersion;
    }
})