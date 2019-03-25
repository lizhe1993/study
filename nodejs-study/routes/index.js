var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

//注册
router.get('/reg',function (req,res) {

});
router.post('/reg',function (req,res) {

});

//登录
router.get('/login',function (req,res) {

});
router.post('/login',function (req,res) {

});

//登出
router.get('/logout',function (req,res) {

});


module.exports = router;
