interface TV {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int volume);
    int getChannel();
    void setChannel(int channel);
}

class GeneralTV implements TV {
   int volume;
   int channel;
   public boolean isEnabled()
    {
       return true;
    }
   public void enable()
   {
       System.out.println("General TV enabled.");
   }
    public void disable(){
        System.out.println("General TV disabled.");
    }
   public int getVolume()
    {
       return volume;
    }
    public void setVolume(int volume)
    {
        this.volume = volume;
    }
    public int getChannel()
    {
        return channel;
    }
    public void setChannel(int channel){
        this.channel = channel;
    }
}

class SmartTV implements TV {
    int volume;
    int channel;
    public boolean isEnabled()
     {
        return true;
     }
    public void enable()
    {
        System.out.println("Smart TV enabled.");
    }
     public void disable(){
         System.out.println("Smart TV disabled.");
     }
    public int getVolume()
     {
        return volume;
     }
     public void setVolume(int volume)
     {
         this.volume = volume;
     }
     public int getChannel()
     {
         return channel;
     }
     public void setChannel(int channel){
         this.channel = channel;
     }

    void Youtube() {
       System.out.println("SmartTV played on YouTube");
    }
}

abstract class Remote {
     protected TV tv;
   public Remote(TV tv) {
        this.tv = tv;
    }

  abstract void togglePower();
  abstract void volumeUp();
   abstract void volumeDown();
   abstract void channelUp();
    abstract void channelDown();
}

class GeneralRemote extends Remote{
    // GeneralRemote(GeneralTV tv)
    // {
    //     super(tv);
    // }

    public GeneralRemote(TV tv)
    {
        super(tv);
    }

   void togglePower() {
        if (tv.isEnabled()) {
            tv.disable();
        } else {
            tv.enable();
        }
    }

    void volumeUp() {
        
        tv.setVolume(tv.getVolume() + 1);
    }

    void volumeDown() {
        tv.setVolume(tv.getVolume() - 1);
    }

    void channelUp() {
        tv.setChannel(tv.getChannel() + 1);
    }

    void channelDown() {
        tv.setChannel(tv.getChannel() - 1);
    }

}

class SmartRemote extends Remote {
    SmartRemote(TV tv) {
        super(tv);
    }

    void togglePower() {
        if (tv.isEnabled()) {
            tv.disable();
        } else {
            tv.enable();
        }
    }

    void volumeUp() {
        
        tv.setVolume(tv.getVolume() + 1);
    }

    void volumeDown() {
        tv.setVolume(tv.getVolume() - 1);
    }
    void channelUp() {
        tv.setChannel(tv.getChannel() + 1);
    }

    void channelDown() {
        tv.setChannel(tv.getChannel() - 1);
    }


    void showYoutube() {
        ((SmartTV) tv).Youtube();
    }
}

public class main {
    public static void main(String[] args) {
        GeneralTV generalTV = new GeneralTV();
        SmartTV smartTV = new SmartTV();

        
        SmartRemote smartRemote = new SmartRemote(smartTV);
        GeneralRemote generalRemote = new GeneralRemote(smartTV);
    
        SmartRemote smartRemote1 = new SmartRemote(generalTV);
        GeneralRemote generalRemote1 = new GeneralRemote(generalTV);

        // Both remotes can operate GeneralTV and SmartTV
        smartRemote.togglePower();
        generalRemote.togglePower();
        generalRemote1.togglePower();
        smartRemote1.togglePower();

        // Access Youtube on SmartTV
        smartRemote.showYoutube();

    }
}
