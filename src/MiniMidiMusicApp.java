// Jordan Laing - 15009237
// Last Modified - 15/11/2018
// MiniMidiMusicApp.java - contains main method

import javax.sound.midi.*;

public class MiniMidiMusicApp {

    public static void main(String[] args) {

        //Create new 'mini' object and call 'play' method
        MiniMidiMusicApp mini = new MiniMidiMusicApp();
        mini.play();
    }

    public void play() {


        //try running the
        try {

            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,44,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            a.setMessage(128,1,44,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}