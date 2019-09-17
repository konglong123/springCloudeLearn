<template>
<div>
  <head>
    <title>作业管理系统</title>
  </head>
  <body>
  <div id="login">
    <div class="topcontent">
      <a class="logo"><img src="static/images/logo.png"/></a>
      <a class="lan"><img src="static/images/icon_en.png"/></a>
    </div>
    <div class="content clearfix">
      <div class="cont_rr">
        <div class="cont_r origin">
          <div>
            <div class="login">
              <div class="title">您即将登录：<br /><b>作业管理认证中心</b></div>
              <div class="blank_txt">
                <div class="error_txt" >
                  <p style="display: none" ref="loginFail">账号或密码错误！</p>
                  <p style="display: none" ref="isNull">请输入账号或密码！</p>
                </div>
                <div class="intline">
                  <i class="inticon"><img src="static/images/icon_1.png"/></i>
                  <input id="username" v-model="username"  class="int_name" accesskey="n" type="text" value="" autocomplete="false" placeholder="人员编号"/></div>
                <div class="intline">
                  <i class="inticon"><img src="static/images/icon_2.png"/></i>
                  <input id="password"  v-model="password" class="int_pwd" accesskey="p" type="password" value="" autocomplete="off" placeholder="请输入密码"/></div>
              </div>
              <div class="clearfix login_btncont">
                <button class="loginbtn"  onfocus='this.blur()' accesskey="l" tabindex="4"  @click="loginVerify">登录</button>
              </div>
              <div class="tools clearfix">
                <a href="/getBackPassword.do" target="_blank" class="fl"><img src="static/images/icon_4.png">忘记密码</a>
                <a href="/register.do" target="_blank" class="fr"><img src="static/images/icon_5.png">用户注册</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="footer">
    <div class="footer_cont">
      <p>作业管理系统　维护部门：信息化实验室　电话：17888821571<br>
        推荐使用Chrome、Firefox或IE8.0以上版本的浏览器</p>
    </div>
  </div>
  </body>
</div>
</template>

<script>
  export default {
    name: 'Login',
    data() {
      return {
        verifyResult: 'begin',
        username: "",
        password: "",
      }
    },
    methods: {
      loginVerify() {
        vm.$refs.isNull.style.display = 'none';
        vm.$refs.loginFail.style.display = 'none';
        if (this.username == '' || this.password == '') {
          vm.$refs.isNull.style.display = 'block';
          return;
        }
        var params = new URLSearchParams();
        params.append("username", this.username);
        params.append("password", this.password);
        axios.post('http://localhost:8080/loginVerify.do', params)
          .then(rep => {
            console.log(rep);
            this.verifyResult = rep.data;
          }).catch(err => {
          console.log(err);
        })

      }
    },
    watch: {
      verifyResult: function (val) {
        if (val.role == "NO") {
          vm.$refs.loginFail.style.display = 'block';
        } else {
          window.location.href = "http://localhost:8080/loginSuccess.do?role=" + val.role + "&number=" + val.number;
        }
      }
    }
  }
</script>
<style scoped>
body,div,p,ul,ol,li,dl,dt,dd,h1,h2,h3,h4,h5,h6,table,tr,td,form,input,select,textarea,span,
img,a,em,strong,*{ margin:0; padding:0;}
article,section,aside,nav,header,footer,address,header,hgroup,blockquote,figure,figcaption{
    display:block;}
body{ font-family:"微软雅黑",arial;  font-size:12px;color:#000000;overflow-x: hidden;}
ul,ol,li{ list-style:none;}
input,select,textarea{ vertical-align:middle;}
p,h1,h2,h3,h4,h5,h6,span,textarea, input { font-family: "微软雅黑",arial; }
img{ border:none; vertical-align:middle;}
a{ text-decoration:none; color:#767676;}
.clearfix:after {visibility:hidden; display:block; font-size:0;	content:" "; clear:both; height:0;}
.clearfix {zoom:1;}
body,html{ width:100%;height: 100%;}
body{
    min-height:100%;
    background: #707070;
    width:100%;
    background-image:url(http://nic.buaa.edu.cn/picbed/casback.jpg);
    background-position:center top;
    background-size:cover;
}
.fl{float: left;}
.fr{float: right;}
.fullheight{height: 100%;}
.clear{clear: both;}
input::-webkit-input-placeholder{color:#fff;}
input::-moz-placeholder{/* Mozilla Firefox 19+ */color:#fff;}
input:-moz-placeholder{/* Mozilla Firefox 4 to 18 */color:#fff;}
input:-ms-input-placeholder{/* Internet Explorer 10-11 */color:#fff;}

.topcontent{width: 1400px;margin: 0 auto;position: relative;}
.content{max-width: 1400px;margin: 0 auto;position: absolute;top: 50%;left: 50%;-webkit-transform: translate(-50%,-50%);-moz-transform: translate(-50%,-50%);transform:translate(-50%,-50%);width:70%;}
.cont_l{width: 448px;height: 385px;float: left;background: rgba(0,0,0,0.2);border-radius: 4px;overflow: hidden;}
.cont_rr{width: 350px;max-width:350px; height:385px;float:right;}
.cont_r{width:100%;padding-bottom: 20px;background: rgba(0,0,0,0.2);border-radius: 4px;position: relative;overflow: hidden;}
.bg1{width: 100%;height: 100%;position: absolute;left: 0;top: 0;}
.bg2{width: 100%;height: 100%;position: absolute;left: 0;top: 0;display: none;}
.logo{position: absolute;left: 0px;top: 46px;}
.lan{position: absolute;left: 293px;top: 62px;}
.text{padding:0 47px;font-size: 14px;color: #fff;text-align: left;}

.fullSlide {width: 100%;height: 100%; position: relative;}
.fullSlide .bd {margin: 0 auto;position: relative;z-index: 0;overflow: hidden;height: 317px;}
.fullSlide .bd ul {	width: 100% !important;}
.fullSlide .bd li {width: 100% !important;overflow: hidden;text-align: center;}
.fullSlide .bd li a {display: block;}
.fullSlide .bd li a img{width: 96%;margin: 2%;}
.fullSlide .hd {width: 100%;position: absolute;z-index: 1;bottom: 0;left: 0;height: 30px;line-height: 30px;text-align: center;_background: #000;	_filter: alpha(opacity=60);}
.fullSlide .hd ul {text-align: center;background: #434667; border-radius: 20px; height: 21px;line-height: 21px;border: 1px solid #8688a5; position: absolute;bottom: 14px; left: 50%;-webkit-transform: translate(-50%,0);-moz-transform: translate(-50%,0);transform:translate(-50%,0);}
.fullSlide .hd ul li {cursor: pointer;display: inline-block;width: 9px;height:9px;margin: 6px;background: #c1bcc2;overflow: hidden;line-height: 9999px;border-radius: 50%;}
.fullSlide .hd ul .on {width: 11px;height: 11px;background: #2079d3;margin: 5px 6px;}
.fullSlide .line{width: 100%;height: 1px;background: #8698af;position: absolute;bottom: 25px;}

/*账密登录*/
.login{width: 100%;height: 100%;}
.login .title{color: #fff;font-size: 16px;line-height: 27px;margin-top: 22px;text-align: center;}
.login .intline{width: 260px;height: 41px;margin: 19px auto 0;background: rgba(114,114,114,0.7);border-radius: 3px;position: relative;overflow: hidden;}
.login .inticon{display: inline-block;margin-left: 12px;margin-top: 10px;}
.login .intline .int_name{width: 80%;height: 100%;position: absolute;left: 0;top: 0;background: transparent;border: 0;color: #fff;padding-left: 15%;outline: none;}
.login .intline .int_pwd{width: 80%;height: 100%;position: absolute;left: 0;top: 0;background: transparent;border: 0;color: #fff;padding-left: 15%;outline: none;}
.login .intline .int_yzm{width: 110px;height: 100%;position: absolute;left: 0;top: 0;background: transparent;border: 0;color: #fff;padding-left: 15%;outline: none;}
.login .intline .yzm{position: absolute;right: 14px;top: 5px; border-left: 1px solid #6c6b6b;padding-left: 9px;}
.tools{width: 290px;margin: 26px auto 0;}
.tools a{color: #fff;font-size: 14px;}
.tools a:hover{color: #fdfa00;}
.tools img {margin-right: 10px;width: 17px;}
.login_btncont{width: 260px;height: 41px;margin: 0 auto;padding-top: 19px;}
.login_btncont .loginbtn{width: 140px;height: 40px;color: #fff;font-size: 16px;text-align: center;line-height: 40px;border-radius: 5px;background: #2077d0;cursor: pointer;border:none;float: right;}
.login_btncont .loginbtn:hover{background: #2e84dc;}

.origin .blank_txt{min-height: 120px;}
.origin .login .intline{margin:34px auto 0;}
.origin .login_btncont{padding-top: 25px;}
.origin .login .title{margin-top: 44px;}
.warning .login .title{margin-top: 23px;}
.yzmshow .login .title{margin-top:24px;}
/*登陆成功*/
/*.login_success{display: none;}*/
.login_success h1{font-size: 18px;color: #fff;text-align: center;line-height: 30px;margin-top: 27px;}
.success_box{width: 70%;padding: 0 5%; height: 235px;border: 1px solid #bfbfbf;margin: 20px auto 0;border-radius: 9px;background: rgba(0,0,0,0.2);}
.success_box .title{line-height: 56px;height: 56px;border-bottom: 1px dashed #bfbfbf;text-align: center;}
.success_box .title b{font-size: 18px;color: #ff8000;}
.success_box p{line-height: 26px;color: #fff;font-size: 14px;}
.login_success_txt1{margin-top: 10px;}
.login_success_txt2{margin-top: 25px;}
/*错误登陆*/
.login_error{display: block;}
.login_error .title{margin-top: 34px;}
.error_txt{margin: 10px auto 0;border-radius: 4px;background: rgba(0,0,0,0.2);width: 260px;box-sizing: border-box;}
.error_txt p{margin: 0 auto;font-size: 14px;color: #ff8000;line-height: 20px;padding: 4px 0 5px 0;width:86.1%;}
.login_error .margT{margin-top: 15px;}
.phone_sm_txt1,.phone_sm_txt2,.phone_sm_txt3{text-align: center;color: #fff;line-height: 24px;}
.footer{position: absolute;bottom: 24px;width: 100%;color: #fff;}
.footer_cont{width: 460px;color: #fff;margin: 0 auto;}

/*错误提示*/
.errortips{border-radius: 4px;background: rgba(0,0,0,0.4); position: absolute;top: 50%;left: 50%;-webkit-transform: translate(-50%,-50%);-moz-transform: translate(-50%,-50%);transform:translate(-50%,-50%);width: 430px;min-height: 260px;}
.tips_title .error_icon{position: absolute;top: -32px;left: 0;right: 0;margin: 0 auto;}
.tips_title h1{text-align: center;margin-top: 52px;color: #fff;font-size: 18px;}
.tips_line{width: 80%;height: 1px;background: rgba(255,255,255,0.2);margin: 20px auto 0;}
.error_notice{text-align: center;font-size: 16px;color: #fff;width: 80%;margin: 32px auto 0;}
.error_btns{width: 282px;margin: 0 auto;position: absolute;bottom: 30px;left: 0;right: 0;}
.error_btns>a{width: 126px;height: 36px;line-height: 36px;text-align: center;font-size: 14px;background: #9196ad;display: block;border-radius: 5px;color: #fff;}

.activeLink{color:#fdfa00;}

.isie8 .content{top: 200px;left: 0;right: 0;position: relative;}
.isie8 .cont_l{background: #707070;}
.isie8 .cont_r{background: #707070;}
.isie8 .login .intline .int_name{line-height: 41px;}
.isie8 .login .intline .int_pwd{line-height: 41px;}
.isie8 .login .intline .int_yzm{line-height: 41px;}
.isie8 .login .intline{border: 1px solid #fff;}

/***********************************************************/

/***********************************************************/

@media only screen and (min-width:947px) and (max-width: 1400px) {
    .content{width: 80%;}
    .topcontent{width: 90%;}
    .cont_l{width: 448px;}
    .cont_rr{width: 40%;min-width: 280px;}
    .login .intline{width: 80%;}
    .error_txt{width:80%;}
    .login_btncont{width: 80%;}
    .tools{width: 80%;}
}
@media only screen and (max-width: 946px) {
    .content{width: 90%;}
    .cont_l{display: none;}
    .cont_rr{float: none;margin: 0 auto;}
}
@media only screen and (max-width: 480px) {
    .bg1{display: none;}
    .login_ewm .ewm_box{margin: 0 5%;}
    .success_box{width: 80%;padding: 0 5%;margin-top: 10px;height: 162px;}
    .content{width: 100%;top: 45%;}
    .cont_rr{width: 70%;margin: 0 auto;height: 300px;}
    .logo{top:17px;left:13px;width:160px;}
    .lan{top:23px;width: 20px;left: 178px;}
    .logo img,.lan img{display:block;width: 100%;}
    .changemode{width: 37px;height: 37px;background-size: 100% 100%;}
    .changemode.active{background-size: 100% 100%;}
    .login .title{font-size: 12px;margin-top: 14px;text-align: center;letter-spacing: -1px;}
    .login .intline{margin-top: 11px;height: 34px;line-height: 34px;}
    .login .intline,.error_txt{width:82%;}
    .login_btncont{width: 82%;margin: 0 auto;}
    .login .loginbtn{width: 50%;margin-right: 0;margin-left: auto;margin-top: 11px;height: 30px;line-height: 30px;}
    .tools{width: 82%;margin-top:12px;}
    .login .inticon{width: 12px;height: 12px;}
    .login .inticon img{display: block;width: 100%;}
    .login .intline .int_name{width: 87%;padding-left: 31px;}
    .login .intline .int_pwd{width: 87%;padding-left: 31px;}
    .login .intline .int_yzm{width: 56%;padding-left: 31px;}
    .login .intline .yzm{width: 60px;top:7px}
    .login .intline .yzm img{display: block;width: 100%;}
    .tools a{font-size: 12px;}
    .tools img{width: 12px;margin-right: 7px;}
    .footer_cont p{text-align: left;}
    .login_success h1{font-size: 14px;margin-top: 13px;}
    .success_box .title{height: 28px;line-height: 28px;}
    .success_box .title b{font-size: 14px;}
    .success_box .title img{width: 12px;}
    .success_box p{font-size: 12px;line-height:22px;}
    .login_success_txt1{margin-top: 5px;}
    .login_success_txt2{margin-top: 13px;}
    .login_ewm h1{font-size: 14px;margin-top: 13px;}
    .login_ewm .ewm_box .ewm_area{width: 100px;height: 100px;margin-top: 12px;}
    .login_ewm .ewm_box .ewm_area img{display: block;width: 100%;}
    .phone_sm_txt1,.phone_sm_txt2,.phone_sm_txt3{line-height: 20px;}
    .login_ewm .ewm_box{padding-bottom: 28px;}

    .login_error .title{font-size: 12px;margin-top: 14px;text-align: center;letter-spacing: -1px;}
    .login_error .intline{margin-top: 11px;height: 34px;line-height: 34px;}
    .login_error .intline,.error_txt{width:82%;}
    .login_btncont{width: 82%;margin: 0 auto;}
    .login_error .loginbtn{width: 50%;margin-right: 0;margin-left: auto;margin-top: 11px;height: 30px;line-height: 30px;}
    .tools{width: 82%;margin-top:12px;}
    .login_error .inticon{width: 12px;height: 12px;}
    .login_error .inticon img{display: block;width: 100%;}
    .login_error .intline .int_name{width: 87%;padding-left: 31px;}
    .login_error .intline .int_pwd{width: 87%;padding-left: 31px;}
    .login_error .intline .int_yzm{width: 56%;padding-left: 31px;}
    .login_error .intline .yzm{width: 60px;top:7px}
    .login_error .intline .yzm img{display: block;width: 100%;}
    .error_txt{margin-top: 7px;}
    .error_txt p{font-size: 12px;line-height: 16px;}
    .blank_txt{min-height:0;}
    .footer_cont {width: 90%;}
    .errortips{width: 90%;}
    .error_btns{width: 90%;}
    .error_btns>a{width: 40%;max-width: 126px;}
}



</style>
