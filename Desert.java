/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Logan
 */
public class Desert {
    private int oasis, scorpion, bandit, wagon;
    
    public Desert(int Oasis1, int Scorpion1, int Bandit1, int Wagon1 )
    {
        oasis = Oasis1;
        scorpion = Scorpion1;
        bandit = Bandit1;
        wagon = Wagon1;
    }
    
    public int getOasis() 
    {
        return oasis;
    }

    public void setOasis(int Oasis1) 
    {
        oasis = Oasis1; 
    }

    
    public int getScorpion()
    {
        return scorpion;
    }

    public void setScorpion(int Scorpion1)
    {
        scorpion = Scorpion1;
    }
    
    
    public int getBandit() 
    {
        return bandit;
    }

    public void setBandit(int Bandit1) 
    {
        bandit = Bandit1;
    }

 
    public int getWagon() 
    {
        return wagon;
    }

    void setWagon(int Wagon1)
    {
        wagon = Wagon1;
    }
}
