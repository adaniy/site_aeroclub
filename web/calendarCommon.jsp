<%@page import="java.util.Calendar" %>
<%

  Calendar theCal = Calendar.getInstance();
  int currentYearInt  = theCal.get(Calendar.YEAR);
  int currentMonthInt = theCal.get(Calendar.MONTH);
  int currentDayInt   = theCal.get(Calendar.DATE);
  String currentYearString  = new Integer(currentYearInt).toString();
  String currentMonthString = new Integer(currentMonthInt).toString();


  String newMonth = request.getParameter("month");
  String newYear  = request.getParameter("year");


  if ( newMonth != null )
  {
    currentMonthString = newMonth;
  }
  if ( newYear != null )
  {
    currentYearString = newYear;
  }

 
  int intMonth = new Integer(currentMonthString).intValue();
  int intYear  = new Integer(currentYearString).intValue();


  String monthNames[] = {"Janvier",
                         "Fevrier",
                         "Mars",
                         "Avril",
                         "Mai",
                         "Juin",
                         "Juillet",
                         "Aout",
                         "Septembre",
                         "Octobre",
                         "Novembere",
                         "Decembre" };

  String monthName = monthNames[intMonth];

  int nextYear = intYear;
  int prevYear = intYear;
  int prevMonth = intMonth-1;
  if ( prevMonth==-1 )
  {
    prevMonth=11;
    prevYear--;
  }
  int nextMonth = intMonth+1;
  if ( nextMonth==12 )
  {
    nextMonth = 0;
    nextYear++;
  }

%>


