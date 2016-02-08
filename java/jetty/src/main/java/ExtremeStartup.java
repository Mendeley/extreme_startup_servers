import org.apache.commons.math3.primes.Primes;

import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExtremeStartup extends HttpServlet {

    private static final Pattern ENDS_WITH_NUMBERS = Pattern.compile(".+:(\\s+\\d+,)+\\s+\\d+");

    private static final String NUMBER_TH = "(th|st|nd|rd)";
    private static final Pattern FIBO = Pattern.compile("\\d+"+NUMBER_TH + ".+Fibonacci");



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("A request has arrived");
        System.out.println(req.getParameter("q"));
        resp.getWriter().write(answer(req.getParameter("q")));
    }

    String answer(String parameter) {
        if (parameter == null)
            return "team name";
        Matcher additionMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(parameter);
        if (additionMatcher.matches()) {
            return String.valueOf(Integer.parseInt(additionMatcher.group(1))
                    + Integer.parseInt(additionMatcher.group(2)));
        }


        Matcher maxMatcher = ENDS_WITH_NUMBERS.matcher(parameter);

        if(maxMatcher.find()){
            String str = maxMatcher.group();

            boolean primeCheck = str.indexOf("are primes") > -1;
            boolean maxCheck = str.indexOf("largest") > -1;
            int inx = str.indexOf(':');
            str = str.substring(inx+1);
            String[] tokens = str.split(",");
            int mxI = Integer.MIN_VALUE;
            StringBuffer sb = new StringBuffer();
            for(String token: tokens){
                Integer i = Integer.parseInt(token.trim());
                if(maxCheck){
                    mxI = Math.max(i.intValue(),mxI);
                }
                else if(primeCheck){
                    if(Primes.isPrime(i)){
                        sb.append(i + " ");
                    }
                }
            }
            if(primeCheck){
                return sb.toString();
            }
            else if(maxCheck) {
                return String.valueOf(mxI);
            }

        }
        Matcher plusMatcher = Pattern.compile("\\d+\\s+(plus|multiplied\\s+by)\\s+\\d+").matcher(parameter);
        if(plusMatcher.find()){
            String group = plusMatcher.group();
            boolean isAddition = group.indexOf("plus") > -1;
            String[] tokens = group.split("plus|multiplied\\s+by");
            int result = isAddition ? 0 : 1;
            for(String token: tokens){
                String nm = token.trim();
                if(nm.length() > 0){
                    Integer i = Integer.parseInt(nm);
                    result = isAddition ? result + i.intValue() : result * i.intValue();
                }
            }
            return String.valueOf(result);
        }

        // what is the 19th number in the Fibonacci sequence
        Matcher fiboMatcher = FIBO.matcher(parameter);
        if(fiboMatcher.find()){
            String group = fiboMatcher.group();
            group = group.replaceAll(NUMBER_TH,"");
            group = group.replaceAll("Fibonacci","");
            group = group.trim();
            Integer nFib = Integer.parseInt(group);
            int fn = Fibonacci.fibonacci(nFib);
            return fn + "";
        }

        return "yellow";
    }



    boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

}
