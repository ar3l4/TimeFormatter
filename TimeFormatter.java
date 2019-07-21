public class TimeFormatter {

    public static String formatDuration(int seconds) {

        int minutes = 0;
        int hours = 0;
        int days = 0;
        int years = 0;
        StringBuilder sb = new StringBuilder();

        if(seconds == 0){
          return "now";
        }

        while(seconds>=60){
          minutes++;
          seconds-=60;
        }

        while(minutes>=60){
          hours++;
          minutes-=60;
        }

        while(hours>=24){
          days++;
          hours-=24;
        }

        while(days>=365){
          years++;
          days-=365;
        }

        if(years>0){
         sb.append(years).append(" year").append(years>1 ? "s" : "").append(days>0 ? ", " : "");
        }

        if(days>0){
          sb.append(days).append(" day").append(days>1 ? "s" : "").append(hours>0 ? ", " : "");
        }

        if(hours>0){
         sb.append(hours).append(" hour").append(hours>1 ? "s" : "").append(minutes>0 ? ", " : "");
        }

        if(minutes>0){
          sb.append(minutes).append(" minute").append(minutes>1 ? "s" : "");
        }

        if(!sb.toString().equals("") && seconds>0){
           sb.append(" and ");
        }
        else{
          try{
          sb.replace(sb.lastIndexOf(", "), sb.lastIndexOf(", ")+1, " and");
          }catch(StringIndexOutOfBoundsException siobe){
            System.out.println("string index out of bound e");
          }
        }

        if(seconds>0){
        sb.append(seconds).append(" second").append(seconds>1 ? "s" : "");
      }
        return sb.toString();
    }
}
