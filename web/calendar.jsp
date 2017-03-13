<%@ page import="domaine.Month"%>
<%@ page import="domaine.Planning"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %>
<%@ page import= "java.sql.*"%>
<%@ include file="calendarCommon.jsp" %>

<html>
<head>
  <title>Calendrier</title>
  <link rel="StyleSheet" href="calendar.css" type="text/css" media="screen" />
</head>

<body id="regular_page">

<div id="calendar_main_div">
<table border="1" cellspacing="0" cellpadding="4" id="calendar_table">
  <tr>
    <td width="100%" colspan="7" class="month_year_header">
      <%=monthName%>, <%=intYear%>
    </td>
  </tr>
  <tr class="week_header_row">
    <th width="14%" class="th_day_cell day">Dim</th>
    <th width="14%" class="th_day_cell day">Lun</th>
    <th width="14%" class="th_day_cell day">Mar</th>
    <th width="14%" class="th_day_cell day">Mer</th>
    <th width="14%" class="th_day_cell day">Jeu</th>
    <th width="15%" class="th_day_cell day">Ven</th>
    <th width="15%" class="th_day_cell day">Sam</th>
  </tr>
  
<%
    List<Planning> laListe = (List<Planning>)request.getAttribute("planning") ;
{
  Month aMonth = Month.getMonth( Integer.parseInt(currentMonthString), Integer.parseInt(currentYearString) );
  int [][] days = aMonth.getDays();
  for( int i=0; i<aMonth.getNumberOfWeeks(); i++ )
  {
    %>
    <tr class="week_data_row">
    <%
    for( int j=0; j<7; j++ )
    {
      if( days[i][j] == 0 )
      {
        %><td class="empty_day_cell">&nbsp;</td><%
      }
      else
      {
    %>
  <form action="ServletReservation" method="post">
       <td >
              
      <%        // this is "today"
      String dateBouton,moisBouton;
      if (days[i][j]<10) dateBouton="0"+days[i][j];
      else dateBouton=""+days[i][j]; 
      
      if (aMonth.getMonth()<10) moisBouton="0"+(aMonth.getMonth()+1);
      else moisBouton=""+(aMonth.getMonth()+1); 
          
      String ladate=aMonth.getYear()+"-"+moisBouton+"-"+dateBouton ;
      String avionPlan;
      int confirmation;
      %>
      <input hidden name="annee" value=<%=aMonth.getYear()%> >     </input>
              <input hidden name="mois" value=<%=moisBouton%> >     </input>
      <%

      for(Planning pln : laListe ){
           avionPlan="avion:"+pln.getdate_vol();
 
       if (Objects.equals(ladate, new String(pln.getdate_vol()))){
           
            confirmation=pln.getConfirmation();
            if (confirmation==1){
            %>
            <input class="demande_plan" type="submit" name="avion " value= <%= avionPlan%> >     </input>
            <%
            }
            else if (confirmation==2){
            %>
            <input class="confirm_plan" type="submit" name="avion " value= <%= avionPlan%>  >     </input>
            <%
            }
            else {
            %>
            <input class="passe_plan" type="submit" name="avion " value= <%= avionPlan%> >     </input>
            <%
            }

        }
      }


      if( currentDayInt == days[i][j] && currentMonthInt == aMonth.getMonth() && currentYearInt == aMonth.getYear() )
      {
        %>
        <input class="today_cell" type="submit" name="date" value=<%=dateBouton%> /></td>
        <%
      }
      else
      {
        %>
        <input class="th_day_cell" type="submit" name="date" value=<%=dateBouton%> /></td>
        <%
      }
      %>
  </form>
    <%
      } 
    } 
    %>
    </tr>
  <%}
}
%>
</table>

</div>


<table id="calendar_nav_table" border="0">
  <tr>
    <td id="prev_link">
      <form method="post">
        <input type="submit" name="Précédent" value=" << ">
        <input type="hidden" name="month" value="<%=prevMonth%>">
        <input type="hidden" name="year" value="<%=prevYear%>">
      </form>
    </td>
    <td id="link_to_month_view">
      <form action="calendarMonthPrintView.jsp" method="post">
        <input type="submit" value="Affichage plein écran" class="submit_button">
        <input type="hidden" name="month" value="<%=intMonth%>">
        <input type="hidden" name="year"  value="<%=intYear%>">
      </form>
    </td>
    <td id="next_link">
      <form method="post">
        <input type="submit" name="Suivant" value=" >> ">
        <input type="hidden" name="month" value="<%=nextMonth%>">
        <input type="hidden" name="year" value="<%=nextYear%>">
      </form>
    </td>
  </tr>
        </table>
        <form >
           <select> 

            <%
         int numLigne=0;
         for(Planning pln : laListe ){
            %>
            <option value = <%= pln.getNum_avion() %> > avion numéro = <%= pln.getNum_avion()%> <%= pln.getdate_vol()%></option>
           <%
         }%>
          
          </select>
         </form>

</body>
</html>


