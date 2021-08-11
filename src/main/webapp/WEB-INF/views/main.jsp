<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
   <h1>메인페이지</h1>
   <div style = "text-align: center">
      
      <span style="float:right">${id }님 안녕하세요
         <a href=logout><button>로그아웃</button></a></span>
   </div>
   <h3>구입할 컨텐츠를 선택하세요.</h3>
   <table>
      <tr>
         <td><img src="resources/Images/Intro_350_408.png"></td>
         <td><img src="resources/Images/Java_350_408.png"></td>
         <td><img src="resources/Images/Cpp_350_408.png"></td>
      </tr>
      <tr style="text-align: center">

         <td>100.000포인트</td>
         <td>500,000포인트</td>
         <td>300,000포인트</td>
      </tr>
      <tr>
         <td></td>
         <td></td>
         <td><img src="resources/Images/korea_it.png"></td>
      </tr>
   </table>
</body>
</html>