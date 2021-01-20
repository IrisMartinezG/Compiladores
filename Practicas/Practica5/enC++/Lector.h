#include"GLC.h"
//#include<vector>

using namespace std;

class Lector{
	private:
		GLC gramatica;
	public:
		void leer_archivo(char* direccion);
		void cargar_gramatica(string gram);
		string separar_linea(string s);
};

void Lector::leer_archivo(char* direccion){
	ifstream archivo;
	string gram;
	archivo.open(direccion,ios::in);
	if(archivo.fail()){
		cout<<"No existe la gramatica"<<endl;
		exit(1);
	}else{
		do{
			getline(archivo, gram);
			cargar_gramatica(gram);

		}while(!archivo.eof());
	}
	
	archivo.close();
}

void Lector::cargar_gramatica(string gram){
	if(!(gramatica.val_inicial())){
		gramatica.set_inicial(gram[0]);
	}
	for(int i=0;i<gram.size();i++){
		gramatica.add_terminal(gram[i]);
		gramatica.add_no_terminal(gram[i]);
	}
	gramatica.add_produccion(gram[0],separar_linea(gram));
}

string Lector::separar_linea(string gram){
	int i=3; string alpha;
    	while (i<gram.length()) {
    		string s(1,gram[i]);
		alpha.append(s);
		i++;
    	}
    return alpha;
}

