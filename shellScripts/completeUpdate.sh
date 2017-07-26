#!/bin/bash
#place in /usr/bin/
sudo apt update
sudo apt full-upgrade
sudo apt autoclean
sudo apt-get install -f
sudo apt-get clean
sudo apt autoremove
