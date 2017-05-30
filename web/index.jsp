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
  <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=kZjplBL9HrG59BQcXgESemV1f4DyUNY5">
  </script>
</head>

<body>
<div id="map"></div>
<script type="text/javascript">
    var map = new BMap.Map("map");
    var point = new BMap.Point(116.404, 39.915);
    map.centerAndZoom(point, 15);
</script>
</body>
</html>
