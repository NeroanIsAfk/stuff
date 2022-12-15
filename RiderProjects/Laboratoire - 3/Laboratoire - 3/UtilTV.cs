using System;
using System.Text;

namespace Laboratoire___3
{
    public static class UtilTV
    {
        public static string AfficheProgamme(params Emission[] emissions)
        {
            StringBuilder output = new StringBuilder();

            foreach (Emission emission in emissions)
            {
                if (emission != null)
                {
                    output.Append(emission.Présentation() + "\n");
                }
            }
            
            return output.ToString();
        }

        public static void PrésenteDA(params DessinAnimé[] das)
        {
            foreach (DessinAnimé da in das)
            {
                Console.WriteLine(da.Présentation());
            }
        }
    }
}