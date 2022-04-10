package practice.strings;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class RemoveUnderscores {
    public static void main(String[] args) {
        String decry = "\"#table cols=\"2\"\n" +
                "User_Name root\n" +
                "Authentication_Scheme password\n" +
                "Protocol SSH_Version_2\n" +
                "\n" +
                "Discovery_Method Login_credentials_provided_by_user\n" +
                "Using_sudo No\n" +
                "Authentication_Record Generic_SSH_Auth_Record\"\n" +
                "\"#table cols=\"2\"\n" +
                "Service SSH\n" +
                "User_Name root\n" +
                "Authentication_Record Generic_SSH_Auth_Record\"\n" +
                "\"#table cols=\"2\"\n" +
                "User_Name root\n" +
                "Authentication_Scheme password\n" +
                "Protocol SSH_Version_2\n" +
                "\n" +
                "Discovery_Method Login_credentials_provided_by_user\n" +
                "Using_sudo No\n" +
                "Authentication_Record Generic_SSH_Auth_Record\"\n" +
                "\"#table cols=\"2\"\n" +
                "User_Name root\n" +
                "Authentication__Scheme password\n" +
                "Protocol SSH_Version_2\n" +
                "Discovery_Method Login_credentials_provided_by_user\n" +
                "Using_sudo No\n" +
                "Key_exchange_algorithm curve25519-sha256@libssh.org\n" +
                "Host_key_algorithm ssh-ed25519\n" +
                "Compression_algorithm zlib@openssh.com\n" +
                "Encryption_algorithm aes128-ctr\n" +
                "MAC_algorithm hmac-sha2-256-etm@openssh.com\n" +
                "Authentication_Record 10.115.96.179\"\n" +
                "\"#table cols=\"2\"\n" +
                "User_Name root\n" +
                "Authentication_Scheme password\n" +
                "Protocol SSH_Version_2\n" +
                "Discovery_Method Login_credentials_provided_by_user\n" +
                "Using_sudo No\n" +
                "Key_exchange_algorithm curve25519-sha256\n" +
                "Host_key_algorithm ssh-ed25519\n" +
                "Compression_algorithm zlib@openssh.com\n" +
                "Encryption_algorithm chacha20-poly1305@openssh.com\n" +
                "MAC_algorithm AEAD\n" +
                "Authentication_Record 10.115.67.96\"";
       // Matcher matcher = Pattern.compile("([^_]+_[^_]+)").matcher(decry);
        //System.out.println(matcher.groupCount());
        //for(int i = 0; i<matcher.groupCount(); i++)
          //  System.out.println(matcher.group(i));
        //String[] tokens = Pattern.compile("(#table cols=\"\\d*\")").split(decry);
        decry = decry.replaceAll(" ", " : ")
                .replaceAll("([^_])(_)([^_])", "$1 $3")
                .replaceAll("__", "_")
                .replaceAll("#table : ", "#table ");

        Map<Object, Object> qidDataRecordMap = new HashMap<>();
        qidDataRecordMap.put("1", "abc");
        qidDataRecordMap.put("2", "abc");
        qidDataRecordMap.put("3", "abc");
        qidDataRecordMap.put("4", "abc");
        Map<String, String> vulnDtos = qidDataRecordMap.keySet().stream()
                .collect(Collectors.toMap(x->x.toString(), x->x.toString().concat("1234hfhf")));
        vulnDtos.forEach((x,y) -> System.out.println(x + ":"+ y));
        //System.out.println(decry);
        Date date = new Timestamp(1478302987000L);

        System.out.println(date);
    }
}
