package com.betplay;

import java.util.Hashtable;

import Model.Entity.Coach;
import Model.Entity.Doctor;
import Model.Entity.Player;
import Model.Entity.Team;

public class Controller {
    public Hashtable <String, Team> equipos = new Hashtable<>();
    public Hashtable <String, Player> jugadores = new Hashtable<>();
    public Hashtable <String, Coach> entrenadores = new Hashtable<>();
    public Hashtable <String, Doctor> doctores = new Hashtable<>();
}
