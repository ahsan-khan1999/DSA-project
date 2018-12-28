import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

import static java.lang.String.valueOf;

@SuppressWarnings("ALL")
public class Test {
    public static void main(String[] args) throws Exception{
            Document d =Jsoup.connect("https://en.wikipedia.org/wiki/2017_Census_of_Pakistan").get();
            Element element =d.getAllElements().first();
//        https://en.wikipedia.org/wiki/Demographics_of_Pakistan
        Document d1 =Jsoup.connect("https://en.wikipedia.org/wiki/Demographics_of_Pakistan").get();
        Elements element1 = d.getElementsByClass("wikitable");

//        System.out.println(element1.select("td[align]"));
        ArrayList<String> genderPop = new ArrayList<>();
        genderPop.add(String.valueOf(element1.select("td[align]")));
        for (int i=0; i <genderPop.size() ; i++) {
//            "\"wikitable sortable\">"
//            genderPop.set(i,genderPop.get(i).replace("\"\"",""));
            genderPop.set(i,genderPop.get(i).replace("<td align=",""));
            genderPop.set(i,genderPop.get(i).replace(">",""));
            genderPop.set(i,genderPop.get(i).replaceAll("</td",""));
            genderPop.set(i,genderPop.get(i).replaceAll("\"right\"",""));
            genderPop.set(i,genderPop.get(i).replaceAll("\"left\"",""));
        }

        Map<String,String> genderDataTotal = new HashMap<>();
        for (int i=0; i <genderPop.size() ; i++) {
            String[] genderdata = genderPop.get(i).split("\n");
            genderDataTotal.put("TotalPopulation",genderdata[1]);
            genderDataTotal.put("Males",genderdata[3]);
            genderDataTotal.put("Females",genderdata[5]);
        }
        System.out.println(genderDataTotal.get("TotalPopulation")+"Total Pop Of Pak");
        System.out.println(genderDataTotal.get("Males")+"Total Males");
        System.out.println(genderDataTotal.get("Females")+"Total Females");

//        System.out.println();
//        System.out.println(element1.outerHtml());
            ArrayList<String> a = new ArrayList<>();
            ArrayList<String> b = new ArrayList<>();

            a.add(valueOf(element.getElementById("Census_of_Pakistan")));
            a.add(valueOf(element.getElementsByClass("wikitable sortable").first()));
//            b.add(valueOf(element.getElementById("table.wikitable")));

//            b.add(valueOf(element.getElementsByTag("<table class=wikitable>")));
//        for (int i=0; i <b.size() ; i++) {
//            System.out.println(b.get(i));
//        }
            for (int i=0; i <a.size() ; i++) {
            a.set(i,a.get(i).replaceAll("<div>",""));
            a.set(i,a.get(i).replaceAll("</div>",""));
            a.set(i,a.get(i).replaceAll("<tr>",""));
            a.set(i,a.get(i).replaceAll("</tr>",""));
            a.set(i,a.get(i).replaceAll("<td>",""));
            a.set(i,a.get(i).replaceAll("</td>",""));
            a.set(i,a.get(i).replaceAll("<th>",""));
            a.set(i,a.get(i).replaceAll("</th>",""));
            a.set(i,a.get(i).replaceAll("<tbody>",""));
            a.set(i,a.get(i).replaceAll("<b>",""));
            a.set(i,a.get(i).replaceAll("</b>",""));
            a.set(i,a.get(i).replaceAll("<a href>",""));
            a.set(i,a.get(i).replaceAll("</a>",""));
            a.set(i,a.get(i).replaceAll("<img>",""));
            a.set(i,a.get(i).replaceAll("</img>",""));
            a.set(i,a.get(i).replace("<table class=",""));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Khyber_Pakthunkhwa\" class=\"mw-redirect\" title=\"Khyber Pakthunkhwa\">",""));
            a.set(i,a.get(i).replace("style=\"font-size:114%;margin:0 4em\">","  2018"));
            a.set(i,a.get(i).replace("<div id=",""));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Pakistan_Census\" class=\"mw-redirect\" title=\"Pakistan Census\">Census of Pakistan",""));
            a.set(i,a.get(i).replace("<table class=\">",""));
            a.set(i,a.get(i).replace("<img alt=\"Increase\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Increase2.svg/11px-Increase2.svg.png\" title=",""));
            a.set(i,a.get(i).replace("width=\"11\" height=\"11\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Increase2.svg/17px-Increase2.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Increase2.svg/22px-Increase2.svg.png 2x\" data-file-width=\"300\" data-file-height=\"300\">",""));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Federally_Administered_Tribal_Areas\" title=\"Federally Administered Tribal Areas\">",""));
            a.set(i,a.get(i).replace("<img alt=\"Steady\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/9/96/Steady2.svg/11px-Steady2.svg.png\" title=\"Steady\" width=\"11\" height=\"11\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/9/96/Steady2.svg/17px-Steady2.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/9/96/Steady2.svg/22px-Steady2.svg.png 2x\" data-file-width=\"300\" data-file-height=\"300\">","Steady"));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Sindh\" title=\"Sindh\">",""));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Punjab,_Pakistan\" title=\"Punjab, Pakistan\">",""));
            a.set(i,a.get(i).replace("<img alt=\"Decrease\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Decrease2.svg/11px-Decrease2.svg.png\" title=\"Decrease\" width=\"11\" height=\"11\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Decrease2.svg/17px-Decrease2.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Decrease2.svg/22px-Decrease2.svg.png 2x\" data-file-width=\"300\" data-file-height=\"300\">","Decrease"));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Balochistan,_Pakistan\" title=\"Balochistan, Pakistan\">",""));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Islamabad_Capital_Territory\" title=\"Islamabad Capital Territory\">",""));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Pakistan\" title=\"Pakistan\">",""));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Azad_Kashmir\" title=\"Azad Kashmir\">",""));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Gilgit-Baltistan\" title=\"Gilgit-Baltistan\">",""));
            a.set(i,a.get(i).replace("<a href=\"/wiki/Pakistan\" title=\"Pakistan\">",""));
            a.set(i,a.get(i).replace("<i></i>",""));
            a.set(i,a.get(i).replace("</tbody>",""));
            a.set(i,a.get(i).replace("</table>",""));
            a.set(i,a.get(i).replace("\"wikitable sortable\">",""));
            a.set(i,a.get(i).replace("i>(incl: AJK, GB)</i>",""));
//                System.out.println(a.get(i));
        }
        Map<String, List<String>> map = new HashMap<>();
        String[] ar = new String[2];
        for (int i=0; i <a.size(); i++){
            ar[i] = a.get(i);
        }
//        System.out.println(ar[2]);
        String[] questions =ar[1].split("Khyber Pakthunkhwa");
        map.put("Questions",Collections.singletonList(questions[0]));
        String[] dataofKpk =questions[1].split("Tribal Areas");
        map.put("dataofKpk",Collections.singletonList(dataofKpk[0]));
        String[] tribalAreas = dataofKpk[1].split("Sindh");
        map.put("tribalAreas",Collections.singletonList(tribalAreas[0]));
        String[] dataOfSindh = tribalAreas[1].split("Punjab");
        map.put("dataOfSindh",Collections.singletonList(dataOfSindh[0]));
        String[] dataOfPunjab = dataOfSindh[1].split("Balochistan");
        map.put("dataOfPunjab",Collections.singletonList(dataOfPunjab[0]));
        String[] dataOfBalochistan = dataOfPunjab[1].split("Islamabad Capital Territory");
        map.put("dataOfBalochistan",Collections.singletonList(dataOfBalochistan[0]));
        String[] dataOfIsl = dataOfBalochistan[1].split("PAKISTAN");
        map.put("dataOfIsl",Collections.singletonList(dataOfIsl[0]));
        String[] dataOfPakistanT = dataOfIsl[1].split("Azad Jammu and Kashmir");
        map.put("dataOfPakistanT",Collections.singletonList(dataOfPakistanT[0]));
        String[] dataOfAzadJammuandKashmir = dataOfPakistanT[1].split("Gilgit-Baltistan");
        map.put("dataOfAzadJammuandKashmir",Collections.singletonList(dataOfAzadJammuandKashmir[0]));
        String[] dataOfGilgitBaltistan = dataOfAzadJammuandKashmir[1].split("PAKISTAN <");
        map.put("dataOfGilgitBaltistan",Collections.singletonList(dataOfGilgitBaltistan[0]));
        String[] dataAfterAdingKG = ar[1].split("PAKISTAN <");
//        System.out.println(dataAfterAdingKG[1]);
        map.put("dataAfterAdingKG",Collections.singletonList(dataAfterAdingKG[1]));
//        System.out.println(dataOfGilgitBaltistan[1]);
//        System.out.println(ar[1]);

//        System.out.println(map.get("Questions"));

        String[] splitKpk= dataofKpk[0].split("\n");
        String[]  spitTribe=tribalAreas[0].split("\n");
        String[] splitedSindh =dataOfSindh[0].split("\n");
        String[] splitedPunjab = dataOfPunjab[0].split("\n");
        String[] splitedBalo = dataOfBalochistan[0].split("\n");
        String[] splitedIsl = dataOfIsl[0].split("\n");
        String[] splitedPakT = dataOfPakistanT[0].split("\n");
        String[] splitedKashmir = dataOfAzadJammuandKashmir[0].split("\n");
        String[] splitedBaltistan = dataOfGilgitBaltistan[0].split("\n");
        String[] splitedTP = dataAfterAdingKG[1].split("\n");
        ArrayList<String> houseHolds = new ArrayList<>();
        houseHolds.add(splitKpk[1]+"KPK");
        houseHolds.add(spitTribe[1]+"TribeAreas");
        houseHolds.add(splitedSindh[1]+"Sindh");
        houseHolds.add(splitedPunjab[1]+"Punjab");
        houseHolds.add(splitedBalo[1]+"Balochistan");
        houseHolds.add(splitedIsl[1]+"Isl");
        houseHolds.add(splitedPakT[1]+"Pak");
        houseHolds.add(splitedKashmir[1]+"Kashmir");
        houseHolds.add(splitedBaltistan[1]+"Baltistan");
        houseHolds.add(splitedTP[1]+"Total Pakistan");

        ArrayList<String> totalPopulation1998 = new ArrayList<>();
        totalPopulation1998.add(splitKpk[2]+"KPK");
        totalPopulation1998.add(spitTribe[2]+"TribeAreas");
        totalPopulation1998.add(splitedSindh[2]+"Sindh");
        totalPopulation1998.add(splitedPunjab[2]+"Punjab");
        totalPopulation1998.add(splitedBalo[2]+"Balochistan");
        totalPopulation1998.add(splitedIsl[2]+"Isl");
        totalPopulation1998.add(splitedPakT[2]+"Pak");
        totalPopulation1998.add(splitedKashmir[2]+"Kashimr");
        totalPopulation1998.add(splitedBaltistan[2]+"Baltistan");
        totalPopulation1998.add(splitedTP[2]+"Total Pakistan");

        ArrayList<String> totalPopulation2017 = new ArrayList<>();
        totalPopulation2017.add(splitKpk[3]+"KPK");
        totalPopulation2017.add(spitTribe[3]+"TribeAreas");
        totalPopulation2017.add(splitedSindh[3]+"Sindh");
        totalPopulation2017.add(splitedPunjab[3]+"Punjab");
        totalPopulation2017.add(splitedBalo[3]+"Balochistan");
        totalPopulation2017.add(splitedIsl[3]+"Isl");
        totalPopulation2017.add(splitedPakT[3]+"Pak");
        totalPopulation2017.add(splitedKashmir[3]+"Kashmir");
        totalPopulation2017.add(splitedBaltistan[3]+"Baltistan");
        totalPopulation2017.add(splitedTP[3]+"Total Pakistan");

        ArrayList<String> anualizedGrowth = new ArrayList<>();
        anualizedGrowth.add(splitKpk[4]+"KPK");
        anualizedGrowth.add(spitTribe[4]+"TribeAreas");
        anualizedGrowth.add(splitedSindh[4]+"Sindh");
        anualizedGrowth.add(splitedPunjab[4]+"Punjab");
        anualizedGrowth.add(splitedBalo[4]+"Balochistan");
        anualizedGrowth.add(splitedIsl[4]+"Isl");
        anualizedGrowth.add(splitedPakT[4]+"Pak");
        anualizedGrowth.add(splitedKashmir[4]+"Kashmir");
        anualizedGrowth.add(splitedBaltistan[4]+"Baltistan");
        anualizedGrowth.add(splitedTP[4]+"Total Pakistan");

        ArrayList<String> shareInPopualtion = new ArrayList<>();
        shareInPopualtion.add(splitKpk[5]+"KPK");
        anualizedGrowth.add(spitTribe[5]+"TribeAreas");
        shareInPopualtion.add(splitedSindh[5]+"Sindh");
        shareInPopualtion.add(splitedPunjab[5]+"Punjab");
        shareInPopualtion.add(splitedBalo[5]+"Balochistan");
        shareInPopualtion.add(splitedIsl[5]+"Isl");
        shareInPopualtion.add(splitedPakT[5]+"Pak");
        shareInPopualtion.add(splitedKashmir[5]+"Kashmir");
        shareInPopualtion.add(splitedBaltistan[5]+"Baltistan");
        shareInPopualtion.add(splitedTP[5]+"Total Pakistan");

        Map<String,List<String>> map1 = new HashMap<>();
        map1.put("Households",houseHolds);
        map1.put("totalPopulation1998",totalPopulation1998);
        map1.put("totalPopulation2017",totalPopulation2017);
        map1.put("anualizeGrowth",anualizedGrowth);
        map1.put("shareInPop",shareInPopualtion);

        boolean input = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("For HousHolds press 0");
            System.out.println("For totalpopulation1998 press 1");
            System.out.println("For totalpopulation2017 press 2");
            System.out.println("For anualizegrowth press 3");
            System.out.println("For shareinPop press 4");
            int in= scanner.nextInt();

            if (in == 0){
                System.out.println("HouseHolds"+map1.get("Households"));
                input=true;
            }
            else if (in == 1){

                System.out.println("totalPopulation1998"+map1.get("totalPopulation1998"));
                input=true;
            }
            else if (in == 2){

                System.out.println("totalPopulation2017"+map1.get("totalPopulation2017"));
                input=true;
            }
            else if (in == 3){
                System.out.println("anualizeGrowth"+map1.get("anualizeGrowth"));
                input=true;
            }
            else if (in == 4){
                System.out.println("shareInPop"+map1.get("shareInPop"));
                input=true;
            }
            else {
                System.out.println("Invalid input");
                input=true;
                break;
            }

            input=false;
        }
        while (input!=true);
//        System.out.println(genderDataTotal.get("Total")+"Total Pop");
//        System.out.println(genderDataTotal.get("Males")+"Total Males");
//        System.out.println(genderDataTotal.get("Females")+"Total FeMales");
    }
    }

//        System.out.println(map.get("tribalAreas")+"Data Of TribalAreas");
//        System.out.println(map.get("dataOfSindh")+"Data Of Sindh");
//        System.out.println(map.get("dataOfPunjab")+"Data Of Punjab");
//        System.out.println(map.get("dataOfBalochistan")+"Data Of Balochistan");
//        System.out.println(map.get("dataOfIsl")+"Data Of Isl");
//        System.out.println(map.get("dataOfPakistanT")+"Total Data Of Pakistan ");
//        System.out.println(map.get("dataOfAzadJammuandKashmir")+"Total Data Of AzadJammuandKashmir");
//        System.out.println("dataOfGilgitBaltistan"+map.get("dataOfGilgitBaltistan"));
//        System.out.println("dataAfterAdingKG"+map.get("dataAfterAdingKG"));




//        System.out.println(dataOfKPK[1]);
//        System.out.println(dataOfKPK[1]);
//        for (int i=0; i <dataOfKPK.length ; i++) {
//            System.out.println(dataOfKPK[i]);
//        }



//        while (true){
//                arrayList.add(Arrays.toString(a.get(1).split("Khyber Pakthunkhwa", 0)));
//            if (arrayList.get(0).equals("Tribal Areas")){
//                break;
//            }
//
//        }
// arrayList.add(Arrays.toString(a.get(1).split("Khyber Pakthunkhwa", 0)));
//        arrayList.add(String.valueOf(a.get(1).startsWith("Khyber Pakthunkhwa") && a.get(1).endsWith("\"Increase\" 14.69%")));

//        arrayList.add(String.valueOf(a.get(1).equals("Khyber Pakthunkhwa")String.valueOf(a.get(1).equals("\"Increase\" 14.69%")))

//            System.out.println(arrayList.get(0));


//        System.out.println(element.outerHtml());
//        System.out.println(arrayList.get(0));





// if (a.get(1).equals("Khyber Pakthunkhwa")){
//            String key1 =
//        }
//        for (int i=0; i <a.size() ; i++) {
//            if (a.get(i).equals("Khyber Pakthunkhwa") || a.get(i).equals("Tribal Areas") || a.get(i).equals("Sindh") || a.get(i).equals("Punjab") || a.get(i).equals("") || a.get(i).equals("Balochistan") || a.get(i).equals("Islamabad Capital Territory") || a.get(i).equals("PAKISTAN") || a.get(i).equals("Azad Jammu and Kashmir") || a.get(i).equals("Gilgit-Baltistan") || a.get(i).equals("PAKISTAN <i>(incl: AJK, GB)</i>")){
////                map.ke
//                }
//        System.out.println(a.get(1));
//        ArrayList<String> c = new ArrayList<>();
//        c.add(String.valueOf(a.get(1).split("Khyber Pakthunkhwa")));
//        System.out.println(c.get(0));
//        c.add()

        /*for (int i=0; i <b.size() ; i++) {
            System.out.println(b.get(i));
        }*/
//        for (int i=0; i <element.text(); i++) {
//
//        }
//            System.out.println(element.getElementsByTag("<h2>"));
//            System.out.println(element.getElementsByTag("<p>"));
//            System.out.println(element.getElementsByTag("<table>"));
//            System.out.println(element.outerHtml());
//            System.out.println(element.getElementsByClass("wikitable"));
//            a.add(element.getElementById("wikitable"));
//            b.add(String.valueOf(element.getElementsByClass("wikitable").first()));
//            System.out.println(element.getElementsByClass("wikitable sortable"));
//        for (int i=0; i <a.size() ; i++) {
//            ar =a.get(1).split("Khyber Pakthunkhwa");
//            ar = a.get(1).split("Tribal Areas");
////        }
//        String[] splitedAfterKGTPak = dataOfGilgitBaltistan[1].split("\n");
//        System.out.println(splitedAfterKGTPak[1]+"as");
//        System.out.println(splitedAfterKGTPak[2]);
//        System.out.println(splitedAfterKGTPak[3]);
//        System.out.println(splitedAfterKGTPak[4]);
//        System.out.println(splitedAfterKGTPak[5]);

//        ArrayList<String> administrativeUnit = new ArrayList<>();
//        administrativeUnit.add(splitKpk[1]+"KPK");
//        administrativeUnit.add(spitTribe[1]+"Tribe");
//        administrativeUnit.add(splitedSindh[1]+"Sindh");
//        administrativeUnit.add(splitedBalo[1]+"Balochistan");
//        administrativeUnit.add(splitedIsl[1]+"Islamabad");
//        administrativeUnit.add(splitedPakT[1]+"Pakistan");
//        administrativeUnit.add(splitedKashmir[1]+"Kashmir");
//        administrativeUnit.add(splitedBaltistan[1]+"Baltistan");
//        administrativeUnit.add(splitedAfterKGTPak[1]+"PakTotal");
