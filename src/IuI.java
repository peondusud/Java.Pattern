
public interface IuI {

	void create();

	void setcopyCMD(Icmd copy);
	void setcollerCMD(Icmd coller);
	void setdeleteCMD(Icmd delete);
	void setundoCMD( Icmd undo);
	void setredoCMD(Icmd redo);
	void setcutCMD(Icmd cut);
	void setrefreshCMD(Icmd refresh);
	void  setinsertCMD(Icmd insert);
	void setaddCharCMD(Icmd addchar);
	void setBuffer(Ibuffer ib);

}
