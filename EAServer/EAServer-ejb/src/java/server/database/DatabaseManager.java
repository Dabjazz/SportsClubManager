/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.database;

import contract.domain.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import server.domain.classes.*;

/**
 @author Thomas
 */
public class DatabaseManager
{
    public static void clearDatabase()
    {
        try
        {
            DomainFacade.getInstance().delete(Match.class);
            DomainFacade.getInstance().delete(Competition.class);
            DomainFacade.getInstance().delete(League.class);

            DomainFacade.getInstance().delete(ClubTeam.class);
            DomainFacade.getInstance().delete(Team.class);

            DomainFacade.getInstance().delete(Department.class);
            DomainFacade.getInstance().delete(Player.class);
            DomainFacade.getInstance().delete(DepartmentHead.class);
            DomainFacade.getInstance().delete(Trainer.class);
            DomainFacade.getInstance().delete(Member.class);
            DomainFacade.getInstance().delete(Country.class);
            DomainFacade.getInstance().delete(TypeOfSport.class);
        }
        catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void restoreDefault()
    {
       // clearDatabase();

        restoreTypeOfSport();
        restoreCountry();
        restorePlayer();
        restoreTrainer();

        restoreDepartmentHead();
        restoreDepartment();

        restoreClubTeams();
        restoreTeams();

        restoreCompetitions();
    }

    private static void restoreTypeOfSport()
    {
        String[] values = new String[]
        {
            "Basketball",
            "Baseball",
            "American Football",
            "Football",
            "Cricket",
            "Hockey",
            "Ice hockey",
            "Rugby",
            "Curling",
            "Fistball",
            "Volleyball",
            "Beachvolleyball"
        };
        try
        {
            for (String value : values)
            {

                TypeOfSport type = new TypeOfSport();
                type.setName(value);
                type.setDescription("");
                DomainFacade.getInstance().set(type);

            }
        }
        catch (CouldNotSaveException ex)
        {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void restoreCountry()
    {
        try
        {
            DomainFacade.getInstance().set(new Country("AFG", "AF", ".af", " Afghanistan", "Afghanistan", "Afganistán", " Afghanistan", "Afghanistan", " Afeganistão"));
            DomainFacade.getInstance().set(new Country("ALB", "AL", ".al", "Albania", "Albanien", "Albania", " Albanie", "Albania", " Albânia"));
            DomainFacade.getInstance().set(new Country("ATA", "AQ", ".aq", "Antarctica", "Antarktis", "Antártida", " Antarctique", "Antartide", " Antárctida"));
            DomainFacade.getInstance().set(new Country("DZA", "DZ", ".dz", "Algeria", "Algerien", "Argelia", " Algerie !Algérie", "Algeria", " Argélia"));
            DomainFacade.getInstance().set(new Country("ASM", "AS", ".as", "American Samoa", "Amerikanisch-Samoa", "Samoa Americana", " Samoa americaines !Samoa américaines", "Samoa Americane", " Samoa Americana"));
            DomainFacade.getInstance().set(new Country("AND", "AD", ".ad", "Andorra", "Andorra", "Andorra", " Andorre", "Andorra", " Andorra"));
            DomainFacade.getInstance().set(new Country("AGO", "AO", ".ao", "Angola", "Angola", "Angola", " Angola", "Angola", " Angola"));
            DomainFacade.getInstance().set(new Country("ATG", "AG", ".ag", "Antigua and Barbuda", "Antigua und Barbuda", "Antigua y Barbuda", " Antigua-et-Barbuda", "Antigua e Barbuda", " Antigua e Barbuda"));
            DomainFacade.getInstance().set(new Country("AZE", "AZ", ".az", "Azerbaijan", "Aserbaidschan", "Azerbaiyán", " Azerbaidjan !Azerbaïdjan", "Azerbaijan", " Azerbeijão"));
            DomainFacade.getInstance().set(new Country("ARG", "AR", ".ar", "Argentina", "Argentinien", "Argentina", " Argentine", "Argentina", " Argentina"));
            DomainFacade.getInstance().set(new Country("AUS", "AU", ".au", "Australia", "Australien", "Australia", " Australie", "Australia", " Austrália"));
            DomainFacade.getInstance().set(new Country("AUT", "AT", ".at", "Austria", "Österreich", "Austria", " Autriche", "Austria", " Áustria"));
            DomainFacade.getInstance().set(new Country("BHS", "BS", ".bs", "Bahamas", "Bahamas", "Bahamas", " Bahamas", "Bahamas", " Bahamas"));
            DomainFacade.getInstance().set(new Country("BHR", "BH", ".bh", "Bahrain", "Bahrain", "Bahréin", " Bahrein !Bahreïn", "Bahrain", " Bahrain"));
            DomainFacade.getInstance().set(new Country("BGD", "BD", ".bd", "Bangladesh", "Bangladesch", "Bangladesh", " Bangladesh", "Bangladesh", " Bangladesh"));
            DomainFacade.getInstance().set(new Country("ARM", "AM", ".am", "Armenia", "Armenien", "Armenia", " Armenie !Arménie", "Armenia", " Arménia"));
            DomainFacade.getInstance().set(new Country("BRB", "BB", ".bb", "Barbados", "Barbados", "Barbados", " Barbade", "Barbados", " Barbados"));
            DomainFacade.getInstance().set(new Country("BEL", "BE", ".be", "Belgium", "Belgien", "Bélgica", " Belgique", "Belgio", " Bélgica"));
            DomainFacade.getInstance().set(new Country("BMU", "BM", ".bm", "Bermuda", "Bermuda", "Bermudas", " Bermudes", "Bermuda", " Bermuda"));
            DomainFacade.getInstance().set(new Country("BTN", "BT", ".bt", "Bhutan", "Bhutan", "Bután", " Bhoutan", "Bhutan", " Butão"));
            DomainFacade.getInstance().set(new Country("BOL", "BO", ".bo", "Bolivia", "Bolivien", "Bolivia", " Bolivie", "Bolivia", " Bolívia"));
            DomainFacade.getInstance().set(new Country("BIH", "BA", ".ba", "Bosnia and Herzegovina", "Bosnien und Herzegowina", "Bosnia y Herzegovina", " Bosnie-Herzégovine", "Bosnia-Erzegovina", " Bósnia-Herzegovina"));
            DomainFacade.getInstance().set(new Country("BWA", "BW", ".bw", "Botswana", "Botswana", "Botsuana", " Botswana", "Botswana", " Botswana"));
            DomainFacade.getInstance().set(new Country("BVT", "BV", ".bv", "Bouvet Island", "Bouvetinsel", "Isla Bouvet", " Ile Bouvet !Île Bouvet", "Isola Bouvet", " Ilha Bouvet"));
            DomainFacade.getInstance().set(new Country("BRA", "BR", ".br", "Brazil", "Brasilien", "Brasil", " Bresil !Brésil", "Brasile", " Brasil"));
            DomainFacade.getInstance().set(new Country("BLZ", "BZ", ".bz", "Belize", "Belize", "Belice", " Belize", "Belize", " Belize"));
            DomainFacade.getInstance().set(new Country("IOT", "IO", ".io", "British Indian Ocean Territory", "Britisches Territorium im Indischen Ozean", "Territorio Británico del Océano Índico", " Territoire britannique de locean Indien !Territoire britannique de locéan Indien", "Territorio Britannico dellOceano Indiano", " Território Britânico do Oceano Índico"));
            DomainFacade.getInstance().set(new Country("SLB", "SB", ".sb", "Solomon Islands", "Salomonen", "Islas Salomón", " Iles Salomon !Îles Salomon", "Isole Solomon", " Ilhas Salomão"));
            DomainFacade.getInstance().set(new Country("VGB", "VG", ".vg", "Virgin Islands, British", "Britische Jungferninseln", "Islas Vírgenes Británicas", " Iles vierges britanniques !Îles Vierges britanniques", "Territori Britannici dellOceano Indiano", " Ilhas Virgens Britânicas"));
            DomainFacade.getInstance().set(new Country("BRN", "BN", ".bn", "Brunei Darussalam", "Brunei Darussalam", "Brunéi", " Brunei", "Brunei Darussalam", " Brunei"));
            DomainFacade.getInstance().set(new Country("BGR", "BG", ".bg", "Bulgaria", "Bulgarien", "Bulgaria", " Bulgarie", "Bulgaria", " Bulgária"));
            DomainFacade.getInstance().set(new Country("BUR", "BU", ".mm", "Myanmar", "Myanmar (Burma)", "Myanmar", " Birmanie", "Myanmar", " Myanmar (antiga \"\"Birmânia\"\")"));
            DomainFacade.getInstance().set(new Country("MMR", "MM", ".mm", "Myanmar", "Myanmar (Burma)", "Myanmar", " Birmanie", "Myanmar", " Myanmar (antiga \"\"Birmânia\"\")"));
            DomainFacade.getInstance().set(new Country("BDI", "BI", ".bi", "Burundi", "Burundi", "Burundi", " Burundi", "Burundi", " Burundi"));
            DomainFacade.getInstance().set(new Country("BLR", "BY", ".by", "Belarus", "Belarus (Weißrussland)", "Bielorrusia", " Bielorussie !Biélorussie", "Bielorussia", " Bielo-Rússia"));
            DomainFacade.getInstance().set(new Country("KHM", "KH", ".kh", "Cambodia", "Kambodscha", "Camboya", " Cambodge", "Cambogia", " Cambodja"));
            DomainFacade.getInstance().set(new Country("CMR", "CM", ".cm", "Cameroon", "Kamerun", "Camerún", " Cameroun", "Camerun", " Camarões"));
            DomainFacade.getInstance().set(new Country("CAN", "CA", ".ca", "Canada", "Kanada", "Canadá", " Canada", "Canada", " Canadá"));
            DomainFacade.getInstance().set(new Country("CPV", "CV", ".cv", "Cape Verde", "Kap Verde", "Cabo Verde", " Cap-Vert", "Capo Verde", " Cabo Verde"));
            DomainFacade.getInstance().set(new Country("CYM", "KY", ".ky", "Cayman Islands", "Kaimaninseln", "Islas Caimán", " Îles Caïmanes", "Isole Cayman", " Ilhas Cayman"));
            DomainFacade.getInstance().set(new Country("CAF", "CF", ".cf", "Central African Republic", "Zentralafrikanische Republik", "República Centroafricana", " Centrafrique", "Repubblica Centroafricana", " República Centro-africana"));
            DomainFacade.getInstance().set(new Country("LKA", "LK", ".lk", "Sri Lanka", "Sri Lanka", "Sri Lanka", " Sri Lanka", "Sri Lanka", " Sri Lanka"));
            DomainFacade.getInstance().set(new Country("TCD", "TD", ".td", "Chad", "Tschad", "Chad", " Tchad", "Ciad", " Chade"));
            DomainFacade.getInstance().set(new Country("CHL", "CL", ".cl", "Chile", "Chile", "Chile", " Chili", "Cile", " Chile"));
            DomainFacade.getInstance().set(new Country("CHN", "CN", ".cn", "China", "China, Volksrepublik", "China", " Chine", "Cina", " China"));
            DomainFacade.getInstance().set(new Country("TWN", "TW", ".tw", "Taiwan, Province of China", "Republik China (Taiwan)", "Taiwán", " Taïwan / (République de Chine)", "Taiwan", " Taiwan"));
            DomainFacade.getInstance().set(new Country("CXR", "CX", ".cx", "Christmas Island", "Weihnachtsinsel", "Isla de Navidad", " Ile Christmas !Île Christmas", "Isola di Natale", " Ilha Christmas"));
            DomainFacade.getInstance().set(new Country("CCK", "CC", ".cc", "Cocos (Keeling) Islands", "Kokosinseln", "Islas Cocos", " Îles Cocos", "Isole Cocos", " Ilhas Cocos"));
            DomainFacade.getInstance().set(new Country("COL", "CO", ".co", "Colombia", "Kolumbien", "Colombia", " Colombie", "Colombia", " Colômbia"));
            DomainFacade.getInstance().set(new Country("COM", "KM", ".km", "Comoros", "Komoren", "Comoras", " Comores", "Comore", " Comores"));
            DomainFacade.getInstance().set(new Country("MYT", "YT", ".yt", "Mayotte", "Mayotte", "Mayotte", " Mayotte", "Mayotte", " Mayotte"));
            DomainFacade.getInstance().set(new Country("COG", "CG", ".cg", "Congo", "Republik Kongo", "República del Congo", " Congo-Brazzaville / (Congo)", "Repubblica del Congo", " República do Congo"));
            DomainFacade.getInstance().set(new Country("COD", "CD", ".cd", "Congo, Democratic Republic of the", "Zaire (jetzt Demokratische Republik Kongo)", "República Democrática del Congo", " Congo-Kinshasa / (République démocratique du Congo)", "Repubblica Democratica del Congo", " República Democrática do Congo"));
            DomainFacade.getInstance().set(new Country("ZAR", "ZR", ".cd", "Congo, Democratic Republic of the", "Zaire (jetzt Demokratische Republik Kongo)", "República Democrática del Congo", " Congo-Kinshasa / (République démocratique du Congo)", "Repubblica Democratica del Congo", " República Democrática do Congo"));
            DomainFacade.getInstance().set(new Country("COK", "CK", ".ck", "Cook Islands", "Cookinseln", "Islas Cook", " Îles Cook", "Isole Cook", " Ilhas Cook"));
            DomainFacade.getInstance().set(new Country("CRI", "CR", ".cr", "Costa Rica", "Costa Rica", "Costa Rica", " Costa Rica", "Costa Rica", " Costa Rica"));
            DomainFacade.getInstance().set(new Country("HRV", "HR", ".hr", "Croatia", "Kroatien", "Croacia", " Croatie", "Croazia", " Croácia"));
            DomainFacade.getInstance().set(new Country("CUB", "CU", ".cu", "Cuba", "Kuba", "Cuba", " Cuba", "Cuba", " Cuba"));
            DomainFacade.getInstance().set(new Country("CYP", "CY", ".cy", "Cyprus", "Zypern", "Chipre", " Chypre (pays)||CHYPRE", "Cipro", " Chipre"));
            DomainFacade.getInstance().set(new Country("CZE", "CZ", ".cz", "Czech Republic", "Tschechische Republik", "República Checa", " Republique tcheque !République tchèque", "Repubblica Ceca", " República Checa"));
            DomainFacade.getInstance().set(new Country("BEN", "BJ", ".bj", "Benin", "Benin", "Benín", " Benin !Bénin", "Benin", " Benin"));
            DomainFacade.getInstance().set(new Country("DNK", "DK", ".dk", "Denmark", "Dänemark", "Dinamarca", " Danemark", "Danimarca", " Dinamarca"));
            DomainFacade.getInstance().set(new Country("DMA", "DM", ".dm", "Dominica", "Dominica", "Dominica", " Dominique", "Dominica", " Dominica"));
            DomainFacade.getInstance().set(new Country("DOM", "DO", ".do", "Dominican Republic", "Dominikanische Republik", "República Dominicana", " Republique dominicaine !République dominicaine", "Repubblica Dominicana", " República Dominicana"));
            DomainFacade.getInstance().set(new Country("ECU", "EC", ".ec", "Ecuador", "Ecuador", "Ecuador", " Equateur !Équateur", "Ecuador", " Equador"));
            DomainFacade.getInstance().set(new Country("SLV", "SV", ".sv", "El Salvador", "El Salvador", "El Salvador", " Salvador", "El Salvador", " El Salvador"));
            DomainFacade.getInstance().set(new Country("GNQ", "GQ", ".gq", "Equatorial Guinea", "Äquatorialguinea", "Guinea Ecuatorial", " Guinee equatoriale !Guinée équatoriale", "Guinea Equatoriale", " Guiné Equatorial"));
            DomainFacade.getInstance().set(new Country("ETH", "ET", ".et", "Ethiopia", "Äthiopien", "Etiopía", " Ethiopie !Éthiopie", "Etiopia", " Etiópia"));
            DomainFacade.getInstance().set(new Country("ERI", "ER", ".er", "Eritrea", "Eritrea", "Eritrea", " Erythree !Érythrée", "Eritrea", " Eritreia"));
            DomainFacade.getInstance().set(new Country("EST", "EE", ".ee", "Estonia", "Estland", "Estonia", " Estonie", "Estonia", " Estónia"));
            DomainFacade.getInstance().set(new Country("FRO", "FO", ".fo", "Faroe Islands", "Färöer", "Islas Feroe", " Iles Feroe !Îles Féroé", "Isole Faroe", " Ilhas Faroe"));
            DomainFacade.getInstance().set(new Country("FLK", "FK", ".fk", "Falkland Islands (Malvinas)", "Falklandinseln", "Islas Malvinas", " Iles Malouines !Îles Malouines", "Isole Falkland", " Ilhas Malvinas"));
            DomainFacade.getInstance().set(new Country("SGS", "GS", ".gs", "South Georgia and the South Sandwich Islands", "Südgeorgien und die Südlichen Sandwichinseln", "Islas Georgias del Sur y Sandwich del Sur", " Géorgie du Sud et les îles Sandwich du Sud", "Sud Georgia e Isole Sandwich", " Ilhas Geórgia do Sul e Sandwich do Sul"));
            DomainFacade.getInstance().set(new Country("FJI", "FJ", ".fj", "Fiji", "Fidschi", "Fiyi", " Fidji", "Fiji", " Fiji"));
            DomainFacade.getInstance().set(new Country("FIN", "FI", ".fi", "Finland", "Finnland", "Finlandia", " Finlande", "Finlandia", " Finlândia"));
            DomainFacade.getInstance().set(new Country("ALA", "AX", ".ax", "Åland Islands", "Åland", "Åland", " Aland !Åland", "Åland", " Åland"));
            DomainFacade.getInstance().set(new Country("FRA", "FR", ".fr", "France", "Frankreich", "Francia", " France", "Francia", " França"));
            DomainFacade.getInstance().set(new Country("GUF", "GF", ".gf", "French Guiana", "Französisch-Guayana", "Guayana Francesa", " Guyane", "Guyana Francese", " Guiana Francesa"));
            DomainFacade.getInstance().set(new Country("PYF", "PF", ".pf", "French Polynesia", "Französisch-Polynesien", "Polinesia Francesa", " Polynesie francaise !Polynésie française", "Polinesia Francese", " Polinésia Francesa"));
            DomainFacade.getInstance().set(new Country("ATF", "TF", ".tf", "French Southern Territories", "Französische Süd- und Antarktisgebiete", "Territorios Australes Franceses", " Terres australes et antarctiques françaises", "Territori Francesi del Sud", " Terras Austrais e Antárticas Francesas (\"\"TAAF\"\")"));
            DomainFacade.getInstance().set(new Country("DJI", "DJ", ".dj", "Djibouti", "Dschibuti", "Yibuti", " Djibouti", "Gibuti", " Djibouti"));
            DomainFacade.getInstance().set(new Country("GAB", "GA", ".ga", "Gabon", "Gabun", "Gabón", " Gabon", "Gabon", " Gabão"));
            DomainFacade.getInstance().set(new Country("GEO", "GE", ".ge", "Georgia", "Georgien", "Georgia", " Géorgie (pays)", "Georgia", " Geórgia"));
            DomainFacade.getInstance().set(new Country("GMB", "GM", ".gm", "Gambia", "Gambia", "Gambia", " Gambie", "Gambia", " Gâmbia"));
            DomainFacade.getInstance().set(new Country("PSE", "PS", ".ps", "Palestinian Territory, Occupied", "Palästinensische Autonomiegebiete", "Palestina (ANP)", " Palestine", "Territori Palestinesi Occupati", " Palestina"));
            DomainFacade.getInstance().set(new Country("DEU", "DE", ".de", "Germany", "Deutschland", "Alemania", " Allemagne", "Germania", " Alemanha"));
            DomainFacade.getInstance().set(new Country("GHA", "GH", ".gh", "Ghana", "Ghana", "Ghana", " Ghana", "Ghana", " Gana"));
            DomainFacade.getInstance().set(new Country("GIB", "GI", ".gi", "Gibraltar", "Gibraltar", "Gibraltar", " Gibraltar", "Gibilterra", " Gibraltar"));
            DomainFacade.getInstance().set(new Country("KIR", "KI", ".ki", "Kiribati", "Kiribati", "Kiribati", " Kiribati", "Kiribati", " Kiribati"));
            DomainFacade.getInstance().set(new Country("GRC", "GR", ".gr", "Greece", "Griechenland", "Grecia", " Grece !Grèce", "Grecia", " Grécia "));
            DomainFacade.getInstance().set(new Country("GRL", "GL", ".gl", "Greenland", "Grönland", "Groenlandia", " Groenland", "Groenlandia", " Gronelândia"));
            DomainFacade.getInstance().set(new Country("GRD", "GD", ".gd", "Grenada", "Grenada", "Granada", " Grenade (pays)||GRENADE", "Grenada", " Grenada"));
            DomainFacade.getInstance().set(new Country("GLP", "GP", ".gp", "Guadeloupe", "Guadeloupe", "Guadalupe", " Guadeloupe", "Guadalupa", " Guadeloupe"));
            DomainFacade.getInstance().set(new Country("GUM", "GU", ".gu", "Guam", "Guam", "Guam", " Guam", "Guam", " Guam"));
            DomainFacade.getInstance().set(new Country("GTM", "GT", ".gt", "Guatemala", "Guatemala", "Guatemala", " Guatemala", "Guatemala", " Guatemala"));
            DomainFacade.getInstance().set(new Country("GIN", "GN", ".gn", "Guinea", "Guinea", "Guinea", " Guinee !Guinée", "Guinea", " Guiné-Conacri"));
            DomainFacade.getInstance().set(new Country("GUY", "GY", ".gy", "Guyana", "Guyana", "Guyana", " Guyana", "Guyana", " Guiana"));
            DomainFacade.getInstance().set(new Country("HTI", "HT", ".ht", "Haiti", "Haiti", "Haití", " Haiti !Haïti", "Haiti", " Haiti"));
            DomainFacade.getInstance().set(new Country("HMD", "HM", ".hm", "Heard Island and McDonald Islands", "Heard- und McDonald-Inseln", "Islas Heard y McDonald", " Île Heard et îles McDonald", "Isole Heard e McDonald", " Ilha Heard e Ilhas McDonald"));
            DomainFacade.getInstance().set(new Country("VAT", "VA", ".va", "Holy See (Vatican City State)", "Vatikanstadt", "Ciudad del Vaticano", " Vatican / (Saint-Siège)", "Città del Vaticano", " Vaticano"));
            DomainFacade.getInstance().set(new Country("HND", "HN", ".hn", "Honduras", "Honduras", "Honduras", " Honduras", "Honduras", " Honduras"));
            DomainFacade.getInstance().set(new Country("HKG", "HK", ".hk", "Hong Kong", "Hongkong", "Hong Kong", " Hong Kong", "Hong Kong", " Hong Kong"));
            DomainFacade.getInstance().set(new Country("HUN", "HU", ".hu", "Hungary", "Ungarn", "Hungría", " Hongrie", "Ungheria", " Hungria"));
            DomainFacade.getInstance().set(new Country("ISL", "IS", ".is", "Iceland", "Island", "Islandia", " Islande", "Islanda", " Islândia"));
            DomainFacade.getInstance().set(new Country("IND", "IN", ".in", "India", "Indien", "India", " Inde", "India", " Índia"));
            DomainFacade.getInstance().set(new Country("IDN", "ID", ".id", "Indonesia", "Indonesien", "Indonesia", " Indonesie !Indonésie", "Indonesia", " Indonésia"));
            DomainFacade.getInstance().set(new Country("IRN", "IR", ".ir", "Iran, Islamic Republic of", "Iran", "Irán", " Iran", "Iran", " Irão"));
            DomainFacade.getInstance().set(new Country("IRQ", "IQ", ".iq", "Iraq", "Irak", "Iraq", " Irak", "Iraq", " Iraque"));
            DomainFacade.getInstance().set(new Country("IRL", "IE", ".ie", "Ireland", "Irland", "Irlanda", " Irlande (pays)||IRLANDE", "Eire", " Irlanda"));
            DomainFacade.getInstance().set(new Country("ISR", "IL", ".il", "Israel", "Israel", "Israel", " Israel !Israël", "Israele", " Israel"));
            DomainFacade.getInstance().set(new Country("ITA", "IT", ".it", "Italy", "Italien", "Italia", " Italie", "Italia", " Itália"));
            DomainFacade.getInstance().set(new Country("CIV", "CI", ".ci", "Côte dIvoire", "Elfenbeinküste", "Costa de Marfil", " Cote dIvoire !Côte dIvoire ", "Costa dAvorio", " Costa do Marfim"));
            DomainFacade.getInstance().set(new Country("JAM", "JM", ".jm", "Jamaica", "Jamaika", "Jamaica", " Jamaique !Jamaïque", "Giamaica", " Jamaica"));
            DomainFacade.getInstance().set(new Country("JPN", "JP", ".jp", "Japan", "Japan", "Japón", " Japon", "Giappone", " Japão"));
            DomainFacade.getInstance().set(new Country("KAZ", "KZ", ".kz", "Kazakhstan", "Kasachstan", "Kazajistán", " Kazakhstan", "Kazakistan", " Cazaquistão"));
            DomainFacade.getInstance().set(new Country("JOR", "JO", ".jo", "Jordan", "Jordanien", "Jordania", " Jordanie", "Giordania", " Jordânia"));
            DomainFacade.getInstance().set(new Country("KEN", "KE", ".ke", "Kenya", "Kenia", "Kenia", " Kenya", "Kenya", " Quénia"));
            DomainFacade.getInstance().set(new Country("PRK", "KP", ".kp", "Korea, Democratic Peoples Republic of", "Nordkorea", "Corea del Norte", " Coree du Nord !Corée du Nord", "Corea del Nord", " Coreia do Norte"));
            DomainFacade.getInstance().set(new Country("KOR", "KR", ".kr", "Korea, Republic of", "Südkorea", "Corea del Sur", " Coree du Sud !Corée du Sud", "Corea del Sud", " Coreia do Sul"));
            DomainFacade.getInstance().set(new Country("KWT", "KW", ".kw", "Kuwait", "Kuwait", "Kuwait", " Koweit !Koweït", "Kuwait", " Kuwait"));
            DomainFacade.getInstance().set(new Country("KGZ", "KG", ".kg", "Kyrgyzstan", "Kirgisistan", "Kirguistán", " Kirghizistan", "Kirghizistan", " Quirguistão"));
            DomainFacade.getInstance().set(new Country("LAO", "LA", ".la", "Lao Peoples Democratic Republic", "Laos", "Laos", " Laos", "Laos", " Laos"));
            DomainFacade.getInstance().set(new Country("LBN", "LB", ".lb", "Lebanon", "Libanon", "Líbano", " Liban", "Libano", " Líbano"));
            DomainFacade.getInstance().set(new Country("LSO", "LS", ".ls", "Lesotho", "Lesotho", "Lesoto", " Lesotho", "Lesotho", " Lesoto"));
            DomainFacade.getInstance().set(new Country("LVA", "LV", ".lv", "Latvia", "Lettland", "Letonia", " Lettonie", "Lettonia", " Letónia"));
            DomainFacade.getInstance().set(new Country("LBR", "LR", ".lr", "Liberia", "Liberia", "Liberia", " Liberia !Libéria", "Liberia", " Libéria"));
            DomainFacade.getInstance().set(new Country("LBY", "LY", ".ly", "Libyan Arab Jamahiriya", "Libyen", "Libia", " Libye", "Libia", " Líbia"));
            DomainFacade.getInstance().set(new Country("LIE", "LI", ".li", "Liechtenstein", "Liechtenstein", "Liechtenstein", " Liechtenstein", "Liechtenstein", " Liechtenstein"));
            DomainFacade.getInstance().set(new Country("LTU", "LT", ".lt", "Lithuania", "Litauen", "Lituania", " Lituanie", "Lituania", " Lituânia"));
            DomainFacade.getInstance().set(new Country("LUX", "LU", ".lu", "Luxembourg", "Luxemburg", "Luxemburgo", " Luxembourg (pays)", "Lussemburgo", " Luxemburgo"));
            DomainFacade.getInstance().set(new Country("MAC", "MO", ".mo", "Macao", "Macao", "Macao", " Macao", "Macao", " Macau"));
            DomainFacade.getInstance().set(new Country("MDG", "MG", ".mg", "Madagascar", "Madagaskar", "Madagascar", " Madagascar", "Madagascar", " Madagáscar"));
            DomainFacade.getInstance().set(new Country("MWI", "MW", ".mw", "Malawi", "Malawi", "Malawi", " Malawi", "Malawi", " Malawi"));
            DomainFacade.getInstance().set(new Country("MYS", "MY", ".my", "Malaysia", "Malaysia", "Malasia", " Malaisie", "Malesia", " Malásia"));
            DomainFacade.getInstance().set(new Country("MDV", "MV", ".mv", "Maldives", "Malediven", "Maldivas", " Maldives", "Maldive", " Maldivas"));
            DomainFacade.getInstance().set(new Country("MLI", "ML", ".ml", "Mali", "Mali", "Malí", " Mali", "Mali", " Mali"));
            DomainFacade.getInstance().set(new Country("MLT", "MT", ".mt", "Malta", "Malta", "Malta", " Malte", "Malta", " Malta"));
            DomainFacade.getInstance().set(new Country("MTQ", "MQ", ".mq", "Martinique", "Martinique", "Martinica", " Martinique", "Martinica", " Martinica"));
            DomainFacade.getInstance().set(new Country("MRT", "MR", ".mr", "Mauritania", "Mauretanien", "Mauritania", " Mauritanie", "Mauritania", " Mauritânia"));
            DomainFacade.getInstance().set(new Country("MUS", "MU", ".mu", "Mauritius", "Mauritius", "Mauricio", " Maurice (pays)", "Mauritius", " Maurícia"));
            DomainFacade.getInstance().set(new Country("MEX", "MX", ".mx", "Mexico", "Mexiko", "México", " Mexique", "Messico", " México"));
            DomainFacade.getInstance().set(new Country("MCO", "MC", ".mc", "Monaco", "Monaco", "Mónaco", " Monaco", "Monaco", " Mónaco"));
            DomainFacade.getInstance().set(new Country("MNG", "MN", ".mn", "Mongolia", "Mongolei", "Mongolia", " Mongolie", "Mongolia", " Mongólia"));
            DomainFacade.getInstance().set(new Country("MDA", "MD", ".md", "Moldova, Republic of", "Moldawien", "Moldavia", " Moldavie", "Moldavia", " Moldávia"));
            DomainFacade.getInstance().set(new Country("MNE", "ME", ".me", "Montenegro", "Montenegro", "Montenegro", " Montenegro !Monténégro", "Montenegro", " Montenegro"));
            DomainFacade.getInstance().set(new Country("MSR", "MS", ".ms", "Montserrat", "Montserrat", "Montserrat", " Montserrat", "Montserrat", " Montserrat"));
            DomainFacade.getInstance().set(new Country("MAR", "MA", ".ma", "Morocco", "Marokko", "Marruecos", " Maroc", "Marocco", " Marrocos"));
            DomainFacade.getInstance().set(new Country("MOZ", "MZ", ".mz", "Mozambique", "Mosambik", "Mozambique", " Mozambique", "Mozambico", " Moçambique"));
            DomainFacade.getInstance().set(new Country("OMN", "OM", ".om", "Oman", "Oman", "Omán", " Oman", "Oman", " Oman"));
            DomainFacade.getInstance().set(new Country("NAM", "NA", ".na", "Namibia", "Namibia", "Namibia", " Namibie", "Namibia", " Namíbia"));
            DomainFacade.getInstance().set(new Country("NRU", "NR", ".nr", "Nauru", "Nauru", "Nauru", " Nauru", "Nauru", " Nauru"));
            DomainFacade.getInstance().set(new Country("NPL", "NP", ".np", "Nepal", "Nepal", "Nepal", " Nepal !Népal", "Nepal", " Nepal"));
            DomainFacade.getInstance().set(new Country("NLD", "NL", ".nl", "Netherlands", "Niederlande", "Países Bajos", " Pays-Bas", "Paesi Bassi", " Países Baixos (\"\"Holanda\"\")"));
            DomainFacade.getInstance().set(new Country("ANT", "AN", ".an", "Netherlands Antilles", "Niederländische Antillen", "Antillas Neerlandesas", " Antilles neerlandaises !Antilles néerlandaises", "Antille Olandesi", " Antilhas Holandesas"));
            DomainFacade.getInstance().set(new Country("ABW", "AW", ".aw", "Aruba", "Aruba", "Aruba", " Aruba", "Aruba", " Aruba"));
            DomainFacade.getInstance().set(new Country("NCL", "NC", ".nc", "New Caledonia", "Neukaledonien", "Nueva Caledonia", " Nouvelle-Caledonie !Nouvelle-Calédonie", "Nuova Caledonia", " Nova Caledónia"));
            DomainFacade.getInstance().set(new Country("VUT", "VU", ".vu", "Vanuatu", "Vanuatu", "Vanuatu", " Vanuatu", "Vanuatu", " Vanuatu"));
            DomainFacade.getInstance().set(new Country("NZL", "NZ", ".nz", "New Zealand", "Neuseeland", "Nueva Zelanda", " Nouvelle-Zelande !Nouvelle-Zélande", "Nuova Zelanda", " Nova Zelândia (\"\"Aotearoa\"\")"));
            DomainFacade.getInstance().set(new Country("NIC", "NI", ".ni", "Nicaragua", "Nicaragua", "Nicaragua", " Nicaragua", "Nicaragua", " Nicarágua"));
            DomainFacade.getInstance().set(new Country("NER", "NE", ".ne", "Niger", "Niger", "Níger", " Niger", "Niger", " Níger"));
            DomainFacade.getInstance().set(new Country("NGA", "NG", ".ng", "Nigeria", "Nigeria", "Nigeria", " Nigeria", "Nigeria", " Nigéria"));
            DomainFacade.getInstance().set(new Country("NIU", "NU", ".nu", "Niue", "Niue", "Niue", " Niue !Niué", "Niue", " Niue"));
            DomainFacade.getInstance().set(new Country("NFK", "NF", ".nf", "Norfolk Island", "Norfolkinsel", "Norfolk", " Norfolk", "Isola Norfolk", " Ilha Norfolk"));
            DomainFacade.getInstance().set(new Country("NOR", "NO", ".no", "Norway", "Norwegen", "Noruega", " Norvege !Norvège", "Norvegia", " Noruega"));
            DomainFacade.getInstance().set(new Country("MNP", "MP", ".mp", "Northern Mariana Islands", "Nördliche Marianen", "Islas Marianas del Norte", " Iles Mariannes du Nord !Îles Mariannes du Nord", "Isole Marianne Settentrionali", " Marianas Setentrionais"));
            DomainFacade.getInstance().set(new Country("UMI", "UM", ".um", "United States Minor Outlying Islands", "United States Minor Outlying Islands", "Islas ultramarinas de Estados Unidos", " Iles mineures eloignees des Etats-Unis !Îles mineures éloignées des États-Unis", "Isole Minori degli Stati Uniti dAmerica", " Ilhas Menores Distantes dos Estados Unidos"));
            DomainFacade.getInstance().set(new Country("FSM", "FM", ".fm", "Micronesia, Federated States of", "Mikronesien", "Micronesia", " Micronésie (pays)", "Stati Federati della Micronesia", " Estados Federados da Micronésia"));
            DomainFacade.getInstance().set(new Country("MHL", "MH", ".mh", "Marshall Islands", "Marshallinseln", "Islas Marshall", " Marshall (pays)", "Isole Marshall", " Ilhas Marshall"));
            DomainFacade.getInstance().set(new Country("PLW", "PW", ".pw", "Palau", "Palau", "Palaos", " Palaos", "Palau", " Palau"));
            DomainFacade.getInstance().set(new Country("PAK", "PK", ".pk", "Pakistan", "Pakistan", "Pakistán", " Pakistan", "Pakistan", " Paquistão"));
            DomainFacade.getInstance().set(new Country("PAN", "PA", ".pa", "Panama", "Panama", "Panamá", " Panamá", "Panamá", " Panamá"));
            DomainFacade.getInstance().set(new Country("PNG", "PG", ".pg", "Papua New Guinea", "Papua-Neuguinea", "Papúa Nueva Guinea", " Papouasie-Nouvelle-Guinée", "Papua Nuova Guinea", " Papua-Nova Guiné"));
            DomainFacade.getInstance().set(new Country("PRY", "PY", ".py", "Paraguay", "Paraguay", "Paraguay", " Paraguay", "Paraguay", " Paraguai"));
            DomainFacade.getInstance().set(new Country("PER", "PE", ".pe", "Peru", "Peru", "Perú", " Perou !Pérou", "Perù", " Peru"));
            DomainFacade.getInstance().set(new Country("PHL", "PH", ".ph", "Philippines", "Philippinen", "Filipinas", " Philippines", "Filippine", " Filipinas"));
            DomainFacade.getInstance().set(new Country("PCN", "PN", ".pn", "Pitcairn", "Pitcairninseln", "Islas Pitcairn", " Pitcairn", "Pitcairn", " Pitcairn"));
            DomainFacade.getInstance().set(new Country("POL", "PL", ".pl", "Poland", "Polen", "Polonia", " Pologne", "Polonia", " Polónia"));
            DomainFacade.getInstance().set(new Country("PRT", "PT", ".pt", "Portugal", "Portugal", "Portugal", " Portugal", "Portogallo", " Portugal"));
            DomainFacade.getInstance().set(new Country("GNB", "GW", ".gw", "Guinea-Bissau", "Guinea-Bissau", "Guinea-Bissau", " Guinee Bissau !Guinée-Bissau", "Guinea-Bissau", " Guiné-Bissau"));
            DomainFacade.getInstance().set(new Country("TLS", "TL", ".tl", "Timor-Leste", "Osttimor", "Timor Oriental", " Timor oriental", "Timor Est", " Timor-Leste"));
            DomainFacade.getInstance().set(new Country("PRI", "PR", ".pr", "Puerto Rico", "Puerto Rico", "Puerto Rico", " Porto Rico", "Porto Rico", " Porto Rico"));
            DomainFacade.getInstance().set(new Country("QAT", "QA", ".qa", "Qatar", "Katar", "Qatar", " Qatar", "Qatar", " Qatar"));
            DomainFacade.getInstance().set(new Country("REU", "RE", ".re", "Réunion", "Reunion", "Reunión", " Reunion !La Réunion", "Reunion", " Reunião"));
            DomainFacade.getInstance().set(new Country("ROU", "RO", ".ro", "Romania", "Rumänien", "Rumania", " Roumanie", "Romania", " Roménia"));
            DomainFacade.getInstance().set(new Country("RWA", "RW", ".rw", "Rwanda", "Ruanda", "Ruanda", " Rwanda", "Ruanda", " Ruanda"));
            DomainFacade.getInstance().set(new Country("SHN", "SH", ".sh", "Saint Helena", "St. Helena", "Santa Helena", " Sainte-Hélène (territoire)", "SantElena", " Santa Helena"));
            DomainFacade.getInstance().set(new Country("KNA", "KN", ".kn", "Saint Kitts and Nevis", "St. Kitts und Nevis", "San Cristóbal y Nieves", " Saint-Christophe-et-Niévès", "Saint Kitts e Nevis", " São Cristóvão e Névis"));
            DomainFacade.getInstance().set(new Country("AIA", "AI", ".ai", "Anguilla", "Anguilla", "Anguila", " Anguilla", "Anguilla", " Anguilla"));
            DomainFacade.getInstance().set(new Country("LCA", "LC", ".lc", "Saint Lucia", "St. Lucia", "Santa Lucía", " Sainte-Lucie", "Santa Lucia", " Santa Lúcia"));
            DomainFacade.getInstance().set(new Country("SPM", "PM", ".pm", "Saint Pierre and Miquelon", "Saint-Pierre und Miquelon", "San Pedro y Miquelón", " Saint-Pierre-et-Miquelon", "Saint Pierre e Miquelon", " Saint Pierre et Miquelon"));
            DomainFacade.getInstance().set(new Country("VCT", "VC", ".vc", "Saint Vincent and the Grenadines", "St. Vincent und die Grenadinen", "San Vicente y las Granadinas", " Saint-Vincent-et-les Grenadines", "Saint Vincent e Grenadine", " São Vicente e Granadinas"));
            DomainFacade.getInstance().set(new Country("SMR", "SM", ".sm", "San Marino", "San Marino", "San Marino", " Saint-Marin", "San Marino", " San Marino"));
            DomainFacade.getInstance().set(new Country("STP", "ST", ".st", "Sao Tome and Principe", "São Tomé und Príncipe", "Santo Tomé y Príncipe", " Sao Tome-et-Principe !São Tomé-et-Principe", "Sao Tome e Principe", " São Tomé e Príncipe"));
            DomainFacade.getInstance().set(new Country("SAU", "SA", ".sa", "Saudi Arabia", "Saudi-Arabien", "Arabia Saudita", " Arabie saoudite", "Arabia Saudita", " Arábia Saudita"));
            DomainFacade.getInstance().set(new Country("SEN", "SN", ".sn", "Senegal", "Senegal", "Senegal", " Senegal !Sénégal", "Senegal", " Senegal"));
            DomainFacade.getInstance().set(new Country("SRB", "RS", ".rs", "Serbia", "Serbien", "Serbia", " Serbie", "Serbia[1]", " Sérvia"));
            DomainFacade.getInstance().set(new Country("SYC", "SC", ".sc", "Seychelles", "Seychellen", "Seychelles", " Seychelles", "Seychelles", " Seychelles"));
            DomainFacade.getInstance().set(new Country("SLE", "SL", ".sl", "Sierra Leone", "Sierra Leone", "Sierra Leona", " Sierra Leone", "Sierra Leone", " Serra Leoa"));
            DomainFacade.getInstance().set(new Country("SGP", "SG", ".sg", "Singapore", "Singapur", "Singapur", " Singapour", "Singapore", " Singapura"));
            DomainFacade.getInstance().set(new Country("SVK", "SK", ".sk", "Slovakia", "Slowakei", "Eslovaquia", " Slovaquie", "Slovacchia", " Eslováquia"));
            DomainFacade.getInstance().set(new Country("VNM", "VN", ".vn", "Viet Nam", "Vietnam", "Vietnam", " Viêt Nam", "Vietnam", " Vietname"));
            DomainFacade.getInstance().set(new Country("SVN", "SI", ".si", "Slovenia", "Slowenien", "Eslovenia", " Slovenie !Slovénie", "Slovenia", " Eslovénia"));
            DomainFacade.getInstance().set(new Country("SOM", "SO", ".so", "Somalia", "Somalia", "Somalia", " Somalie", "Somalia", " Somália"));
            DomainFacade.getInstance().set(new Country("ZAF", "ZA", ".za", "South Africa", "Südafrika", "Sudáfrica", " Afrique du Sud", "Sudafrica", " África do Sul"));
            DomainFacade.getInstance().set(new Country("ZWE", "ZW", ".zw", "Zimbabwe", "Simbabwe", "Zimbabue", " Zimbabwe", "Zimbabwe", " Zimbabwe"));
            DomainFacade.getInstance().set(new Country("ESP", "ES", ".es", "Spain", "Spanien", "España(Ceuta y Melilla)", " Espagne", "Spagna", " Espanha"));
            DomainFacade.getInstance().set(new Country("ESH", "EH", ".eh", "Western Sahara", "Westsahara", "Sahara Occidental", " Sahara occidental", "Sahara Occidentale", " Saara Ocidental"));
            DomainFacade.getInstance().set(new Country("SDN", "SD", ".sd", "Sudan", "Sudan", "Sudán", " Soudan", "Sudan", " Sudão"));
            DomainFacade.getInstance().set(new Country("SUR", "SR", ".sr", "Suriname", "Suriname", "Surinam", " Suriname", "Suriname", " Suriname"));
            DomainFacade.getInstance().set(new Country("SJM", "SJ", ".sj", "Svalbard and Jan Mayen", "Svalbard und Jan Mayen", "Svalbard y Jan Mayen", " Svalbard et ile Jan Mayen !Svalbard et île Jan Mayen", "Svalbard e Jan Mayen", " Svalbard e Jan Mayen"));
            DomainFacade.getInstance().set(new Country("SWZ", "SZ", ".sz", "Swaziland", "Swasiland", "Suazilandia", " Swaziland", "Swaziland", " Suazilândia"));
            DomainFacade.getInstance().set(new Country("SWE", "SE", ".se", "Sweden", "Schweden", "Suecia", " Suede !Suède", "Svezia", " Suécia"));
            DomainFacade.getInstance().set(new Country("CHE", "CH", ".ch", "Switzerland", "Schweiz", "Suiza", " Suisse", "Svizzera", " Suíça"));
            DomainFacade.getInstance().set(new Country("SYR", "SY", ".sy", "Syrian Arab Republic", "Syrien", "Siria", " Syrie", "Siria", " Síria"));
            DomainFacade.getInstance().set(new Country("TJK", "TJ", ".tj", "Tajikistan", "Tadschikistan", "Tayikistán", " Tadjikistan", "Tagikistan", " Tajiquistão"));
            DomainFacade.getInstance().set(new Country("THA", "TH", ".th", "Thailand", "Thailand", "Tailandia", " Thaïlande", "Thailandia", " Tailândia"));
            DomainFacade.getInstance().set(new Country("TGO", "TG", ".tg", "Togo", "Togo", "Togo", " Togo", "Togo", " Togo"));
            DomainFacade.getInstance().set(new Country("TKL", "TK", ".tk", "Tokelau", "Tokelau", "Tokelau", " Tokelau", "Tokelau", " Toquelau"));
            DomainFacade.getInstance().set(new Country("TON", "TO", ".to", "Tonga", "Tonga", "Tonga", " Tonga", "Tonga", " Tonga"));
            DomainFacade.getInstance().set(new Country("TTO", "TT", ".tt", "Trinidad and Tobago", "Trinidad und Tobago", "Trinidad y Tobago", " Trinité-et-Tobago", "Trinidad e Tobago", " Trindade e Tobago"));
            DomainFacade.getInstance().set(new Country("ARE", "AE", ".ae", "United Arab Emirates", "Vereinigte Arabische Emirate", "Emiratos Árabes Unidos", " Emirats arabes unis !Émirats arabes unis", "Emirati Arabi Uniti", " Emiratos Árabes Unidos"));
            DomainFacade.getInstance().set(new Country("TUN", "TN", ".tn", "Tunisia", "Tunesien", "Túnez", " Tunisie", "Tunisia", " Tunísia"));
            DomainFacade.getInstance().set(new Country("TUR", "TR", ".tr", "Turkey", "Türkei", "Turquía", " Turquie", "Turchia", " Turquia"));
            DomainFacade.getInstance().set(new Country("TKM", "TM", ".tm", "Turkmenistan", "Turkmenistan", "Turkmenistán", " Turkménistan", "Turkmenistan", " Turquemenistão"));
            DomainFacade.getInstance().set(new Country("TCA", "TC", ".tc", "Turks and Caicos Islands", "Turks- und Caicosinseln", "Islas Turcas y Caicos", " Iles Turques et Caiques !Îles Turques et Caïques", "Isole Turks e Caicos", " Turks e Caicos"));
            DomainFacade.getInstance().set(new Country("TUV", "TV", ".tv", "Tuvalu", "Tuvalu", "Tuvalu", " Tuvalu", "Tuvalu", " Tuvalu"));
            DomainFacade.getInstance().set(new Country("UGA", "UG", ".ug", "Uganda", "Uganda", "Uganda", " Ouganda", "Uganda", " Uganda"));
            DomainFacade.getInstance().set(new Country("UKR", "UA", ".ua", "Ukraine", "Ukraine", "Ucrania", " Ukraine", "Ucraina", " Ucrânia"));
            DomainFacade.getInstance().set(new Country("MKD", "MK", ".mk", "Macedonia, the former Yugoslav Republic of", "Mazedonien", "ARY Macedonia", " Macédoine (pays)", "Macedonia", " República da Macedónia"));
            DomainFacade.getInstance().set(new Country("EGY", "EG", ".eg", "Egypt", "Ägypten", "Egipto", " Egypte !Égypte", "Egitto", " Egipto"));
            DomainFacade.getInstance().set(new Country("GBR", "GB", ".uk", "United Kingdom", "Vereinigtes Königreich Großbritannien und Nordirland", "Reino Unido", " Royaume-Uni", "Regno Unito", " Reino Unido"));
            DomainFacade.getInstance().set(new Country("GGY", "GG", ".gg", "Guernsey", "Guernsey (Kanalinsel)", "Guernsey", " Guernesey", "Guernsey", " Guernsey"));
            DomainFacade.getInstance().set(new Country("JEY", "JE", ".je", "Jersey", "Jersey (Kanalinsel)", "Jersey", " Jersey", "Jersey", " Jersey"));
            DomainFacade.getInstance().set(new Country("IMN", "IM", ".im", "Isle of Man", "Insel Man", "Isla de Man", " Ile de Man !Île de Man", "Isola di Man", " Ilha de Man"));
            DomainFacade.getInstance().set(new Country("TZA", "TZ", ".tz", "Tanzania, United Republic of", "Tansania", "Tanzania", " Tanzanie", "Tanzania", " Tanzânia"));
            DomainFacade.getInstance().set(new Country("USA", "US", ".us", "United States", "Vereinigte Staaten von Amerika", "Estados Unidos", " Etats-Unis !États-Unis", "Stati Uniti dAmerica", " Estados Unidos da América"));
            DomainFacade.getInstance().set(new Country("VIR", "VI", ".vi", "Virgin Islands, U.S.", "Amerikanische Jungferninseln", "Islas Vírgenes Estadounidenses", " Iles Vierges americaines !Îles Vierges américaines", "Isole Vergini Americane", " Ilhas Virgens Americanas"));
            DomainFacade.getInstance().set(new Country("BFA", "BF", ".bf", "Burkina Faso", "Burkina Faso", "Burkina Faso", " Burkina Faso", "Burkina Faso", " Burkina Faso"));
            DomainFacade.getInstance().set(new Country("URY", "UY", ".uy", "Uruguay", "Uruguay", "Uruguay", " Uruguay", "Uruguay", " Uruguai"));
            DomainFacade.getInstance().set(new Country("UZB", "UZ", ".uz", "Uzbekistan", "Usbekistan", "Uzbekistán", " Ouzbekistan !Ouzbékistan", "Uzbekistan", " Usbequistão"));
            DomainFacade.getInstance().set(new Country("VEN", "VE", ".ve", "Venezuela", "Venezuela", "Venezuela", " Venezuela", "Venezuela", " Venezuela"));
            DomainFacade.getInstance().set(new Country("WLF", "WF", ".wf", "Wallis and Futuna", "Wallis und Futuna", "Wallis y Futuna", " Wallis-et-Futuna", "Wallis e Futuna", " Wallis e Futuna"));
            DomainFacade.getInstance().set(new Country("WSM", "WS", ".ws", "Samoa", "Samoa", "Samoa", " Samoa", "Samoa", " Samoa (Samoa Ocidental)"));
            DomainFacade.getInstance().set(new Country("YEM", "YE", ".ye", "Yemen", "Jemen", "Yemen", " Yémen", "Yemen", " Iémen"));
            DomainFacade.getInstance().set(new Country("ZMB", "ZM", ".zm", "Zambia", "Sambia", "Zambia", " Zambie", "Zambia", " Zâmbia"));
        }
        catch (CouldNotSaveException ex)
        {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void restorePlayer()
    {
        for (int i = 0; i < 1000; i++)
        {
            try
            {
                Country country = DomainFacade.getInstance().getByName(Country.class, "Togo");
                IAddress address = new Address("Street" + i, i, "Village" + i, 6500 + i, country);
                int day = new Random().nextInt(28);
                int month = new Random().nextInt(12);
                int year = new Random().nextInt(90);

                Date dateOfBirth = DateFormat.getDateInstance().parse(day + "/" + month + "/" + year + " 4:5 PM, PDT");
                Date memberFrom = DateFormat.getDateInstance().parse(day + "/" + month + "/" + (year + 7) + " 4:5 PM, PDT");
                String telephoneNumber = "+43/" + new Random().nextInt();
                String emailAddress = new Random().nextInt(100000) + "@sample.com";

                List<ITypeOfSport> list = new LinkedList<>();
                list.add(DomainFacade.getInstance().getByName(ITypeOfSport.class, "Volleyball"));

                List<IRole> roles = new LinkedList<>();
                roles.add(DomainFacade.getInstance().getByName(IRole.class, "Player"));

                IMember member = new Member();
                member.setPrename("Prename" + i);
                member.setLastname("Lastname" + i);
                member.setAddress(address);
                member.setDateOfBirth(dateOfBirth);
                member.setMemberFrom(memberFrom);
                member.setTelephonenumber(telephoneNumber);
                member.setEmailAddress(emailAddress);
                member.setGender(i % 2 == 0);
                member.setRoleList(roles);
                member.setNationality(country);

                DomainFacade.getInstance().set(member);
            }
            catch (CouldNotSaveException | ParseException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void restoreTrainer()
    {
        for (int i = 0; i < 100; i++)
        {
            try
            {
                Country country = DomainFacade.getInstance().getByName(Country.class, "Togo");
                IAddress address = new Address("Street" + i, i, "Village" + i, 6500 + i, country);
                int day = new Random().nextInt(28);
                int month = new Random().nextInt(12);
                int year = new Random().nextInt(90);

                Date dateOfBirth = DateFormat.getDateInstance().parse(day + "/" + month + "/" + year + " 4:5 PM, PDT");
                Date memberFrom = DateFormat.getDateInstance().parse(day + "/" + month + "/" + (year + 7) + " 4:5 PM, PDT");
                String telephoneNumber = "+43/" + new Random().nextInt();
                String emailAddress = new Random().nextInt(100000) + "@sample.com";

                List<IRole> roles = new LinkedList<>();
                roles.add(DomainFacade.getInstance().getByName(IRole.class, "Trainer"));

                IMember member = new Member();
                member.setPrename("PrenameTrainer" + i);
                member.setLastname("LastnameTrainer" + i);
                member.setAddress(address);
                member.setDateOfBirth(dateOfBirth);
                member.setMemberFrom(memberFrom);
                member.setTelephonenumber(telephoneNumber);
                member.setEmailAddress(emailAddress);
                member.setGender(i % 2 == 0);
                member.setRoleList(roles);
                member.setNationality(country);

                DomainFacade.getInstance().set(member);
            }
            catch (CouldNotSaveException | ParseException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void restoreClubTeams()
    {
        for (int i = 0; i < 10; i++)
        {
            List<IPlayer> players = new LinkedList<>();

            try
            {
                for (int j = 0; j < 20; j++)
                {
                    IPlayer m = DomainFacade.getInstance().getByName(IPlayer.class, "Prename" + (i * 10 + j));
                    players.add(m);
                }

                League league = DomainFacade.getInstance().getByName(League.class, "League" + i);


                IClubTeam team = new ClubTeam();
                team.setName("Team" + i);
                team.setDescription("Description for Team " + i);
                team.setLeague(league);
                team.setPlayerList(players);
                DomainFacade.getInstance().set(team);

                DomainFacade.getInstance().set(team);

            }
            catch (CouldNotSaveException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void restoreTeams()
    {
        for (int i = 0; i < 10; i++)
        {
            League league = DomainFacade.getInstance().getByName(League.class, "League" + i);

            for (int j = 0; j < 19; j++)
            {
                try
                {
                    ITeam team = new Team();
                    team.setName("Foreign Team" + (i * 10 + j));
                    team.setDescription("Description for foreign Team " + (i * 10 + j));
                    team.setLeague(league);
                    DomainFacade.getInstance().set(team);
                }
                catch (CouldNotSaveException ex)
                {
                    Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static void restoreDepartmentHead()
    {
        for (int i = 0; i < 100; i++)
        {
            try
            {
                Country country = DomainFacade.getInstance().getByName(Country.class, "Togo");
                IAddress address = new Address("Street" + i, i, "Village" + i, 6500 + i, country);

                int day = new Random().nextInt(28);
                int month = new Random().nextInt(12);
                int year = new Random().nextInt(90);

                Date dateOfBirth = DateFormat.getDateInstance().parse(day + "/" + month + "/" + year + " 4:5 PM, PDT");
                Date memberFrom = DateFormat.getDateInstance().parse(day + "/" + month + "/" + (year + 7) + " 4:5 PM, PDT");
                String telephoneNumber = "+43/" + new Random().nextInt();
                String emailAddress = new Random().nextInt(100000) + "@sample.com";

                List<IRole> roles = new LinkedList<>();
                roles.add(DomainFacade.getInstance().getByName(Role.class, "DepartmentHead"));

                IMember member = new Member();
                member.setPrename("PrenameDepartmentHead" + i);
                member.setLastname("LastnameDepartmentHead" + i);
                member.setAddress(address);
                member.setDateOfBirth(dateOfBirth);
                member.setMemberFrom(memberFrom);
                member.setTelephonenumber(telephoneNumber);
                member.setEmailAddress(emailAddress);
                member.setGender(i % 2 == 0);
                member.setRoleList(roles);
                member.setNationality(country);

                DomainFacade.getInstance().set(member);
            }
            catch (CouldNotSaveException | ParseException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void restoreDepartment()
    {
        try
        {
            DomainFacade.getInstance().set(new Department("Basketball", "", DomainFacade.getInstance().getByName(ITypeOfSport.class, "Basketball")));
            DomainFacade.getInstance().set(new Department("Baseball", "", DomainFacade.getInstance().getByName(ITypeOfSport.class, "Baseball")));
            DomainFacade.getInstance().set(new Department("American Football", "", DomainFacade.getInstance().getByName(ITypeOfSport.class, "American Football"), DomainFacade.getInstance().getByName(TypeOfSport.class, "Rugby")));
            DomainFacade.getInstance().set(new Department("Football", "", DomainFacade.getInstance().getByName(ITypeOfSport.class, "Football")));
            DomainFacade.getInstance().set(new Department("Cricket", "", DomainFacade.getInstance().getByName(ITypeOfSport.class, "Cricket")));
            DomainFacade.getInstance().set(new Department("Hockey", "", DomainFacade.getInstance().getByName(ITypeOfSport.class, "Hockey"), DomainFacade.getInstance().getByName(TypeOfSport.class, "Ice Hockey")));
            DomainFacade.getInstance().set(new Department("Curling", "", DomainFacade.getInstance().getByName(ITypeOfSport.class, "Curling")));
            DomainFacade.getInstance().set(new Department("Fistball", "", DomainFacade.getInstance().getByName(ITypeOfSport.class, "Fistball")));
            DomainFacade.getInstance().set(new Department("Volleyball", "", DomainFacade.getInstance().getByName(ITypeOfSport.class, "Volleyball"), DomainFacade.getInstance().getByName(TypeOfSport.class, "Beachvolleyball")));
        }
        catch (CouldNotSaveException ex)
        {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void restoreCompetitions()
    {
        for (int i = 1; i <= 10; i++)
        {
            try
            {
                List<ITeam> teams = new LinkedList<>();

                teams.add(DomainFacade.getInstance().getByName(ITeam.class, "Team" + i));

                for (int j = 0; j < 19; j++)
                {
                    teams.add(DomainFacade.getInstance().getByName(ITeam.class, "Foreign Team" + j));
                }

                Date dateFrom = DateFormat.getDateInstance().parse(i + "/12/112 4:5 PM, PDT");
                Date dateTo = DateFormat.getDateInstance().parse((i + 2) + "/12/112 4:5 PM, PDT");

                Competition c = new Competition();

                c.setTeamList(teams);

                for (ITeam team : teams)
                {
                    for (ITeam otherTeam : teams)
                    {
                        if (otherTeam.equals(team))
                        {
                            continue;
                        }

                        IMatch match = new Match();
                        match.setHometeam(team);
                        match.setForeignteam(otherTeam);
                        match.setDateFrom(dateFrom);
                        match.setDateTo(dateTo);
                        match.setCompetition(c);

                        DomainFacade.getInstance().set(match);
                    }
                }

                DomainFacade.getInstance().set(c);
            }
            catch (CouldNotSaveException | ParseException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
