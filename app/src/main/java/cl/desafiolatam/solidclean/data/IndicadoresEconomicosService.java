package cl.desafiolatam.solidclean.data;

public class IndicadoresEconomicosService {

        private static IIndicadoresEconomicosApi mIindicadoresEconomicosApi;

        public static IIndicadoresEconomicosApi getIndicadoresEconomicosService(){
            if(mIindicadoresEconomicosApi==null){
                mIindicadoresEconomicosApi = RetrofitClient.getRetrofitInstance().create(IIndicadoresEconomicosApi.class);
            }
            return mIindicadoresEconomicosApi;
        }
}
