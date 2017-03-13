<%@ page import="domaine.Month"%>
<%@ page import="domaine.Planning"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %>
<%@ page import= "java.sql.*"%>
<%@ include file="calendarCommon.jsp" %>

<html>
<head>
  <title>Calendrier réservation </title>
  <link rel="StyleSheet" href="/calendar.css" type="text/css" media="screen" />
</head>

<body id="print_view_page">
    toto
<div id="calendar_print_view_main_div">
<table border="1" cellspacing="0" cellpadding=4 width="100%" height="100%" id="calendar_table">
  <tr>
    <td colspan="7" class="month_year_header">
      <%=monthName%>, <%=intYear%>
    </td>
  </tr>
  <tr class="week_header_row">
    <th width="14%" class="th_day_cell day">Sun</th>
    <th width="14%" class="th_day_cell day">Mon</th>
    <th width="14%" class="th_day_cell day">Tue</th>
    <th width="14%" class="th_day_cell day">Wed</th>
    <th width="14%" class="th_day_cell day">Thu</th>
    <th width="15%" class="th_day_cell day">Fri</th>
    <th width="15%" class="th_day_cell day">Sat</th>
  </tr>
<%
{
  Month aMonth = Month.getMonth( Integer.parseInt(currentMonthString), Integer.parseInt(currentYearString) );
  int [][] days = aMonth.getDays();
  for( int i=0; i<aMonth.getNumberOfWeeks(); i++ )
  {%>
    <tr>
    <%
    for( int j=0; j<7; j++ )
    {
      if( days[i][j] == 0 )
      {%>
        <td class="empty_day_cell">&nbsp;</td>
      <%}
      else
      {
      %>
         <form action="ServletReservation" method="post">
        <%        // this is "today"
        if( currentDayInt == days[i][j] && currentMonthInt == aMonth.getMonth() && currentYearInt == aMonth.getYear() )
        {
          %><td >
              <input hidden name="annee" value=<%=aMonth.getYear()%> >     </input>
              <input hidden name="mois" value=<%=aMonth.getMonth()%> >     </input>
              <input style="background-color:#ff0000" type="submit" name="date" value=<%=days[i][j]%> />
           </td><%
        }
        else
        {
          %><td ><input class="day_cell" type="submit" name="date" value=<%=days[i][j]%> /></td><%
        }
        %>
        </form>
      <%
      }
    } // end for %>
    </tr>
  <%}
}
%>
</table>
</div>

</body>
</html>


