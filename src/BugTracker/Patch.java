/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

/**
 *
 * @author malla
 */
public class Patch {
    private String patch;
    
    public Patch()
    {
    
    }
    
    public void SetPatch(String patch)
    {
        this.patch = patch;
    }
    public String getPatch()
    {
        return patch;
    }
}
