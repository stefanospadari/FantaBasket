# FantaBasket
applicazione per simulare campionati di basket


### Per far funzionare il progetto
- Cambiare il percorso di hibernate-mapping-3.0.dtd nella riga 5 di ogni file .hbm.xml nella cartella web/WEB-INF/classes/hibernate
- Riga 132 di utils/HibernateUtil.java -> controllare che il percorso di hibernate.cfg.xml sia giusto (dovrebbe essere già apposto)
- Editare il file ant/environment.properties 
