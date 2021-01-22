class TablaM{
	private:
		vector<string> entradas;
		vector<char> filas;
		vector<char> columnas;
	public:
		void guardar_tablaM(string direccion);
		void add_filas(vector<char> a);
		void add_columnas(vector<char> a);
		void mostrar_tablaM();
		void vaciar_tablaM();

};

void TablaM::add_filas(vector<char> a){
	filas=a;
	filas.push_back('$');
}

void TablaM::add_columnas(vector<char> a){
	columnas=a;
}
