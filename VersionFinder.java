import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
public class VersionFinder {

	public void find() throws Exception{
		// TODO Auto-generated constructor stub
		System.out.println("Net Version Source is now loading, please wait");
		int p=512;
		File file=new File("D:/FMCL/versionlist.txt");
		file.createNewFile();
		URL url=new URL("https://launchermeta.mojang.com/mc/game/version_manifest.json");
		URLConnection connecation=url.openConnection();
		InputStream is= connecation.getInputStream();
		BufferedInputStream bis=new BufferedInputStream(is);//ª∫≥Â ‰»Î¡˜
		OutputStream os=new FileOutputStream("D:/FMCL/versionlist.txt");
		BufferedOutputStream bos=new BufferedOutputStream(os);
		byte[] b=new byte[p];
		int len=0;
		while((len=bis.read(b, 0, b.length))!=-1){
			os.write(b);
		}
		bis.close();
		bos.close();
	}

	public static int br() throws Exception{
		System.out.println("Versions Change Type is now loading, please wait");
		File file=new File("D:/FMCL/versionlined.txt");
		file.createNewFile();
		BufferedReader br=new BufferedReader(new FileReader("D:/FMCL/versionlist.txt"));
		String in = br.readLine();
		int skip = in.indexOf("\"versions\": [");
		FileWriter dat = new FileWriter(file,false);
		FileReader r=new FileReader("D:/FMCL/versionlist.txt");
		int lines = 0;
		for(int j=0; j<skip; j++) {
		int get = r.read();
		}
		int last2 = 0;
		int last = 0;
		while(last!=-1) {
			last2 = last;
			last = r.read();
		    dat.write(last);
		    if(last2==125&&last==44) {
		    	dat.write("\r\n");
		    	dat.flush();
		    	lines += 1;
		    }
		}
		dat.close();
		return lines;
	}
	
	public static String[] list(int lines,int thing) throws Exception {
		// TODO Auto-generated method stub
		if(thing==1){
		System.out.println("Versions List is now loading, please wait");
		@SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(new FileReader("D:/FMCL/versionlist.txt"));
		String in = br.readLine();
		int release = in.indexOf("\"release\": \"");
		int snapshot = in.indexOf("\"snapshot\": \"");
		System.out.println("latest release version:"+in.substring(release+12,snapshot-3));
		int v1 = in.indexOf("\"versions\": [");
		System.out.println("latest snapshot version:"+in.substring(snapshot+13,v1-4));
		}
		BufferedReader br2=new BufferedReader(new FileReader("D:/FMCL/versionlined.txt"));
		String nowsearching = "233" ;
		int li_id_pos;
		int li_type_pos;
		int li_url_pos;
		int li_time_pos = 0;
		String li_id;
		String li_type;
		String li_url;
		String li_time;
		String[] vidlist = new String[lines];
		String[] vtypelist = new String[lines];
		String[] vurllist = new String[lines];
		String[] vtimelist = new String[lines];
		int linenow = 0;
		while(!nowsearching.equals("")){
			nowsearching=br2.readLine();
			try {
			li_id_pos=nowsearching.indexOf("\"id\": \"");
			li_type_pos=nowsearching.indexOf("\"type\": \"");
			li_url_pos=nowsearching.indexOf("\"url\": \"");
			li_time_pos=nowsearching.indexOf("\"time\": \"");
			li_id=nowsearching.substring(li_id_pos+7, li_type_pos-3);
			li_type=nowsearching.substring(li_type_pos+9, li_url_pos-3);
			li_url=nowsearching.substring(li_url_pos+8, li_time_pos-3);
			li_time=nowsearching.substring(li_time_pos+9, li_time_pos+28)+"UTC";
			//System.out.println(li_id+" "+li_type+" "+li_url+" "+li_time);
			vidlist[linenow] = li_id;
			vtypelist[linenow] = li_type;
			vurllist[linenow] = li_url;
			vtimelist[linenow] = li_time;
			linenow++;
			}catch(StringIndexOutOfBoundsException w) {
			}catch(NullPointerException np){
				nowsearching="";
			}
		}
		if(thing==1) {
		    return vidlist;
		}else if(thing==2) {
			return vtypelist;
		}else if(thing==3) {
			return vurllist;
		}else {
			return vtimelist;
		}
	}

	public String[] getinfo(String string, String[] versions, String[] vertype, String[] verurl, String[] vertime) {
		// TODO Auto-generated method stub
		int i = 0 ;
		for(i = 0 ;!(string.equals(versions[i]));i++) {
		}
		String[] a = new String[] {vertype[i],verurl[i],vertime[i]};
		if(a[0].equals("release")) {
			a[0]="’˝ Ω∞Ê";
		}else if(a[0].equals("snapshot")) {
			a[0]="≤‚ ‘∞Ê";
		}else if(a[0].equals("old_alpha")) {
			a[0]="‘∂π≈∞Ê";
		}else if(a[0].equals("old_beta")) {
			a[0]="æ≠µ‰∞Ê";
		}
		return a;
	}
}
