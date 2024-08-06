# .bash_profile

# Get the aliases and functions
if [ -f ~/.bashrc ]; then
	. ~/.bashrc
fi

# User specific environment and startup programs

PATH=.:$HOME/bin:/home/myid/kkochut/maven/bin:/usr/local/java/jdk-17.0.3.1/bin:$PATH
CLASSPATH=.:./classes:~/classes:/home/myid/kkochut/classes/junit-4.13.2.jar:/home/myid/kkochut/classes/hamcrest-core-1.3.jar:/home/myid/kkochut/classes/commons-csv-1.10.0.jar
JAVA_HOME=/usr/local/java/jdk-17.0.3.1

#EDITOR=/usr/bin/emacs
#EDITOR=/usr/bin/vim

PS1='\h:\!$ '

HISTFILESIZE=500
HISTSIZE=500

umask 077

alias rm='rm -i'


# export the environment variables
#
export PATH
export CLASSPATH
export JAVA_HOME
#export EDITOR
export PS1
export HISTFILESIZE
export HISTSIZE
