<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>GPS路径显示</title>
  <style type="text/css">
    html{height:100%}
    body{height:100%;margin:0px;padding:0px}
    #map{height:100%}
  </style>
  <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=kZjplBL9HrG59BQcXgESemV1f4DyUNY5"></script>
  <script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
  <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
</head>

<body>
<div id="map"></div>
<script type="text/javascript">
    function JSONLength(obj) {
        var size = 0, key;
        for (key in obj) {
            if (obj.hasOwnProperty(key)) size++;
        }
        return size;
    };
    var map = new BMap.Map("map");
    var point = new BMap.Point(116.404, 39.915);
    map.centerAndZoom(point, 30);
    map.enableScrollWheelZoom();
    $.ajax({
        url:"/gps/getInfo",
        success:function (data) {
            var data = JSON.parse(data);
            var size = JSONLength(data);
            var point = new Array(size);
            map.setCenter(new BMap.Point(parseFloat(data[0].longitude),parseFloat(data[0].latitude)))
            for(var i = 0;i<size;i++){
                point[i] = new BMap.Point(parseFloat(data[i].longitude),parseFloat(data[i].latitude));
            }
            var curve = new BMapLib.CurveLine(point, {strokeColor:"blue", strokeWeight:3, strokeOpacity:0.5});
            map.addOverlay(curve);
            curve.enableEditing();
        }
    })
</script>
</body>
</html>
