
// pattern: verse ==> 'The' adjective noun verb adjective object

//This is the skeleton of a program to generate free style poetry


#include <iostream.h>
#include <stdlib.h>

//list of words: last item should be NULL to mark end
char* verblist[]={"walks", "eats", "sleeps", "works", "studies", NULL};
char* nounlist[] = {"student", "professor", NULL}; 
char* pronounlist[] = {"i", "you", NULL}; 
char* adjlist[] = {"pretty", "smart", "fun", NULL}; 
char* objlist[] = {"flowers", "books", NULL};

int nverbs, nnouns, npronouns, nadj, nobj;



//parameter: a word list 'list' is given 
//action: count the number of words in the list and return it 
int list_size(char* list[]) {
  int n=0;
  while(list[n] != NULL) {
	n++;
  }
  return n;
}


//action: count the number of words in all word lists and initialize
//the global variables 'nverbs', 'nnouns', 'npronouns', 'nadj', 'nobj'
void init() {
  nverbs = list_size(verblist);
  //cout << nverbs << " verbs ";
  nnouns = list_size(nounlist);
  //cout << nnouns << " nouns ";
  npronouns = list_size(pronounlist);
  //cout << npronouns << " pronouns ";
  nadj = list_size(adjlist);
  //cout << nadj << " adjectives ";
  nobj = list_size(objlist);
  //cout << nobj << " objects " << endl;
}


//parameters: a list of words 'list' and its size  'n' are given
//action: print a random word from the list of words
void word(char *list[], int n) {
  int s; 

  //rand() generates a random number in the range 0..RAND_MAX
  //thterefore s is a random number in the range 0..n
  s = rand() % n;

  //print the s-th word from the list of words
  cout << list[s] << " ";
}




//action: print a random verb
void verb() {
  word(verblist, nverbs);
}


//action: print a random noun
void noun() {
  word(nounlist, nnouns);
}


//action: print a random pronoun
void pronoun() {
  word(pronounlist, npronouns);
}


//action: print a random adjective
void adjective() {
  word(adjlist, nadj);
}


//action: print a random object
void object() {
  word(objlist, nobj);
}



//action: generate a verse
void verse() {

  cout << "The ";
  adjective();
  noun(); 
  verb(); 
  adjective();
  object();
  cout << endl;
}



//action: generate a stanza
void  stanza() {
  int i=0; 

  // stanza if 4 verses
  while (i<4) {
    verse();
    i++;
  }
  cout << endl;
}




int  main() {

  //initialize teh list of words
  init();
  
  //initialize the random number generator 
  srand(10);
  

  //generate one stanza
  stanza();


  return 0;
}
