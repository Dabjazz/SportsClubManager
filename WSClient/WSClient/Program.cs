﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WSClient
{
    class Program
    {
        static void Main(string[] args)
        {
            WSRMIClient.ServiceReference1.MatchSvcClient client = new WSRMIClient.ServiceReference1.MatchSvcClient();

            Console.WriteLine("Insert exit to close the programm");
            Console.WriteLine("Press enter button to start request");

            string command = Console.ReadLine();

            while ("exit" != command)
            {
                Console.WriteLine("Insert a type of sport:");
                string typeOfSport = Console.ReadLine();

                Console.WriteLine("Insert a league:");
                string league = Console.ReadLine();

                Console.WriteLine("Insert a date:");
                string competitiondate = Console.ReadLine();

                try
                {
                    var matchresults = client.getMatches(competitiondate, league, typeOfSport);

                    if (matchresults == null || matchresults.Count() == 0)
                    {
                        Console.WriteLine("There are no results");
                    }
                    else
                    {
                        Console.WriteLine();
                        Console.WriteLine("Results");

                        foreach (var matchresult in matchresults)
                        {
                            Console.WriteLine("-----------------------------------------");
                            Console.WriteLine("Id:\t" + matchresult.id);
                            Console.WriteLine("Hometeam:\t" + matchresult.hometeam);
                            Console.WriteLine("Points:\t" + matchresult.pointsHometeam);
                            Console.WriteLine("Foreignteam:\t" + matchresult.foreignteam);
                            Console.WriteLine("Points:\t" + matchresult.pointsForeignteam);

                            Console.WriteLine("-----------------------------------------");
                        }
                    }

                }
                catch (Exception e)
                {
                    Console.WriteLine("An error occured");
                }

                command = Console.ReadLine();
            }
        }
    }
}
