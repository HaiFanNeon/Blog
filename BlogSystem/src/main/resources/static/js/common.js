$(document).ajaxSend(function (e, xhr, opt) {
    var user_token = localStorage.getItem("user_token");
    if (user_token) {
        xhr.setRequestHeader("user_token", user_token);
    }
});

function getUserInfo() {
    $.ajax({
        type: "get",
        url: "user/getUserInfo",
        success: function(res) {
            if (res.code == 200 && res.data != null) {
                // 页面填充
                let user = res.data;
                $(".left .card h3").text(user.userName);
                $(".left .card a").attr("href", user.githubUrl);
            } else {
                location.href = "/blog_login.html";
            }
        }
    })
}

function logout() {
//删除Cookie, 设置Cookie为空即可
    localStorage.removeItem("user_token");
    location.href = "/blog_login.html";
}