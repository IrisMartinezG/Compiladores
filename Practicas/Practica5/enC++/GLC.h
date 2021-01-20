
#include"Produccion.h"
#include"TablaM.h"

using namespace std;

class GLC{
	private:
		vector<char> terminales;
		vector<char> no_terminales;
		vector<Produccion> producciones;
		char inicial;
		int num_produccion=0;
	public:
		void set_inicial(char in);
		void add_produccion(char no_terminal,string alpha);
		void add_terminal(char a);
		void add_no_terminal(char a);
		bool val_inicial();
		bool find_no_terminal(char a);
		bool find_terminal(char a);
		char get_inicial();
		void get_no_terminales();
		void get_terminales();
		void get_producciones();
};

void GLC::add_produccion(char no_terminal, string alpha){
	Produccion a;
	num_produccion++;
	if(no_terminal!=' '){
		a.set_produccion(no_terminal, alpha, num_produccion);
		producciones.push_back(a);
	}
}

void GLC::set_inicial(char in){
	inicial=in;
}

bool GLC::val_inicial(){
	if(65<=inicial && inicial<=90 && inicial!=69){
		return true;
	}else{
		return false;
	}
}

char GLC::get_inicial(){
	return inicial;
}

void GLC::add_terminal(char a){
	if(97<=a && a<=122){
		if(!find_terminal(a))
		
			terminales.push_back(a);
	}
}

void GLC::add_no_terminal(char a){
	if(65<=a && a<=90 && a!=69){
		if(!find_no_terminal(a))
			no_terminales.push_back(a);
	}
}

void GLC::get_no_terminales(){
	for(auto it=no_terminales.begin(); it != no_terminales.end(); it++)
		cout<<*it<<" ";
	//return no_terminales;	
}

void GLC::get_terminales(){
	for(auto it=terminales.begin(); it!= terminales.end(); it++)
		cout<<*it<<" ";
}

bool GLC::find_no_terminal(char a){
	auto it=no_terminales.begin();
	while(it!=no_terminales.end()){
		if(*it==a)
			return true;
		it++;
	}
	if(it==no_terminales.begin())
		return false;
}

bool GLC::find_terminal(char a){
	auto it=terminales.begin();
	while(it!=terminales.end()){
		if(*it==a)
			return true;
		it++;
	}
	if(it==terminales.begin())
		return false;
}
