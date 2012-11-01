package dndhelpermk2.staticMethods;

import dndhelpermk2.player.Player;

public class NumberConverter 
{
        public static int AbiCal(int numberToBeConverted) 
        {
          int result;
          int BaseNr = numberToBeConverted;
          int FirstStage = numberToBeConverted - 8;
          int SecondStage = FirstStage / 2;
          result = SecondStage;
          if (SecondStage * 2 != FirstStage) {
              result += 1;
          }
          return result;
        }
        
        public static void defenseCalculation (Player player) {
        if (player.getStrength() > player.getConstitution())
            {
                player.setFortitude(10 + AbiCal(player.getStrength()) + (HalfLevelCalc(player.getLevel())));
            } else
            {
                player.setFortitude(10 + AbiCal(player.getConstitution()) + (HalfLevelCalc(player.getLevel())));
            }

            //Reflex Calculations
            //TODO: Shield Calculation when equipment system is in place
            if (player.getDexterity() > player.getIntelligence())
            {
                player.setReflex(10 + AbiCal(player.getDexterity()) + (HalfLevelCalc(player.getLevel())));
            } else
            {
                player.setReflex(10 + AbiCal(player.getIntelligence()) + (HalfLevelCalc(player.getLevel())));
            }

            //Will Calculations
            if (player.getWisdom() > player.getCharisma())
            {
                player.setWill(10 + AbiCal(player.getWisdom()) + (HalfLevelCalc(player.getLevel())));
            } else
            {
                player.setWill(10 + AbiCal(player.getCharisma()) + (HalfLevelCalc(player.getLevel())));
            }
            
            player.setAC(10);
    }
        
        public static int HalfLevelCalc(int HalfingValue)
    {
        int temp = HalfingValue / 2;

        if (temp % 2 == 1)
        {
            temp += 1;
        }
        return temp;
    }
}
