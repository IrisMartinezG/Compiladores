using namespace std;

class Produccion{
	private:
		char no_terminal;
		string alpha;
		int num_produccion;
	public:
		void set_produccion(char no_t,string cuerpo,int num);
};

void Produccion::set_produccion(char no_t, string cuerpo, int num){
	alpha=cuerpo;
	num_produccion=num;
	no_terminal=no_t;
	cout<<no_t<<" "<<cuerpo<<" "<<num_produccion<<endl;
}
