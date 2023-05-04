package com.alex.spring.boot.backend.apirest.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "\r\n"
			+ "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEAp+yrQPdg0TJsjCytE+S53HRohrOAjOUwFhZgzL5awFDqHAo5\r\n"
			+ "Zj0KG10wQotmd/w90B7DUsIxgRbAY8rMZioZ/NL6/t5q8L2D7pwIghpS+5lD72uQ\r\n"
			+ "VEZBbJjTGV/j4cVsGvEUvapJkfvRFC/UMDdMkGOYjz4SU/wr0cDu/81FOvGnwdtY\r\n"
			+ "Z/acA8YN4XFK3rm5bDZq1Vi0MgUrprh0E9ZeTsC6DOtTUXK206Yf57w2a079PbYR\r\n"
			+ "NDLMi2BuXvtzYvpCZTt1MHX4LWRQZPuzq0pL68j6mgsppt7z0o/DI1awn+7Ns0G7\r\n"
			+ "rHNfiMusgwDwaYIkGs5YvIsm9wtC75z+gQdGcwIDAQABAoIBAE36X/gWJ/ZdJPze\r\n"
			+ "zix7vTc7M0LB3kMPNoo7MA5Dot7FdEE7GjZ4x9W3K27rTtUO5CFd97PZi6V3TDXK\r\n"
			+ "+anDiTfXPUjXPe+3Aanu+SB5WumM3Xgzid0olr74JKcW2TqBM9c69jew+OL6fbeT\r\n"
			+ "EkSlmT8/kJuL5nTrl+maXyGYT7qztnECh5GP2aZv90AEvuQXgeCkpiT1lkvlk9Gx\r\n"
			+ "5ZaI5vYyisJhVK3vYvVluPYIT+daifLaoLoJkTcP07Xu0cUx5Hwki9boH5egdIOP\r\n"
			+ "2XZzYjeouTJIJ08tqZieUfxa3KFMBVYB3mXiC/yipjR1TlKg5jTucRCvUH0vIgbK\r\n"
			+ "He+6vokCgYEA0alSRRpG5nelvYqMbXeG1B4MumWryKITZUYNfKYFxjjXCo4GhZ8H\r\n"
			+ "d3c6J39LujLoVzk+E8P2ALVcBzuGq89Y3wuHja9yQl+H6u5raU6YGkw3ylMZ740y\r\n"
			+ "heZX1fEzsLw4LAdxMs6uaNzkYItaaXkqMxsaL+4/ss76yEVB83djbk8CgYEAzQnd\r\n"
			+ "hI+QpGSeYKRRPqvplgncrgrI/zvThy0ymzsNnCf4D9aLk+eh134QT5/0rdp8jxvF\r\n"
			+ "9q+8kjnTBLZu5vP5mSLMQckJpREHm3E6ODCX+gdP1mvCIc3KM3luGkcvQ6eUWyU2\r\n"
			+ "tfkc4K1PtPSmzFInzSYOgOLRDw7OejqLDWChYJ0CgYEAwSg3jUZqL4XngjoUqf1G\r\n"
			+ "kEGnBEsK+mqnZ9QkNMRX6YkQRL8YLx6WKHAFecIDKGYiO8mW8WrGR1zOjjM/HSaH\r\n"
			+ "/+WFWvlaUN/mPoCtIHWyF/hEJfhtmo8BDu9p2MbBEoA1WAr7NQ3JDP8EwBVilG12\r\n"
			+ "fWLou2PJ95hM3xk/a2iAiG0CgYEAo12d4vXkYCdPTV7+4LlmtsYKz50GQt5vDoBD\r\n"
			+ "lw05LddmvW/K7ECdYa4u3tJqyG6R2hBd7cxdqgBqkpGs0VVI5Oul5TCB/8QO1Jol\r\n"
			+ "sgl9vZg/028uUXK/Db5NrKBVF0mZWfnPmrPuf1F3dY2MrLU0wy70VVrjCWVZvGeS\r\n"
			+ "zUjVq70CgYArLc7rKBykTwZbvtRH+y7GiV4KxGVgRVf6S88Nl2coQjZabKZUyDvi\r\n"
			+ "tDeDblPs5JPoni6Rt1iqaaM3gYRk0Z8SLbYXBZPrngMYWel2jTt8DyHBewsiDM2e\r\n"
			+ "y8z7S3nb5N10y7a17aW/7tAo5e7GUZ9mWitupDspyDuUFv4ICaJBCA==\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp+yrQPdg0TJsjCytE+S5\r\n"
			+ "3HRohrOAjOUwFhZgzL5awFDqHAo5Zj0KG10wQotmd/w90B7DUsIxgRbAY8rMZioZ\r\n"
			+ "/NL6/t5q8L2D7pwIghpS+5lD72uQVEZBbJjTGV/j4cVsGvEUvapJkfvRFC/UMDdM\r\n"
			+ "kGOYjz4SU/wr0cDu/81FOvGnwdtYZ/acA8YN4XFK3rm5bDZq1Vi0MgUrprh0E9Ze\r\n"
			+ "TsC6DOtTUXK206Yf57w2a079PbYRNDLMi2BuXvtzYvpCZTt1MHX4LWRQZPuzq0pL\r\n"
			+ "68j6mgsppt7z0o/DI1awn+7Ns0G7rHNfiMusgwDwaYIkGs5YvIsm9wtC75z+gQdG\r\n"
			+ "cwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
