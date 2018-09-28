# cross-talk
程序入口：http://localhost:8880
关于thymeleaf重定向中文乱码问题：
使用RedirectAttributes类带值重定向url，若重定向后地址为controller，则需通过@ModelAttribute注解参数获取传来的值。
示例：
public String updateGreatNumber(@PathParam("crossId") Integer crossId, @PathParam("userName") String userName, RedirectAttributes attributes){
        crossService.updateCross(crossId);
        attributes.addFlashAttribute("userName", userName);
        return "redirect:/cross/list/";
@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String crossList(Model model,@ModelAttribute(value = "userName") String userName){
        List<Cross> crossList = crossService.crossList();
        System.out.println("list:--" + userName);
        if(userName == null){
            userName = "";
        }
        System.out.println(userName);
        model.addAttribute("crossList", crossList);
        model.addAttribute("userName", userName);
        return "index";
    }
Idea下maven项目多模块打jar包：
        1.父模块<packaging>pom</packaging>;子模块<packaging>jar</packaging>
        2.在有启动类的模块pom文件中，添加：
        <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.yml</include>
                    <include>**/*.xml</include>
                    <include>**/*.tld</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!-- 指定该Main Class为全局的唯一入口 -->
                    <mainClass>cn.hero.provider.ProviderApplication</mainClass>
                    <layout>ZIP</layout>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <!--可以把依赖的包都打包到生成的Jar包中-->
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
     父模块pom文件中：
     <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.yml</include>
                    <include>**/*.xml</include>
                    <include>**/*.tld</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <configuration>
                        <source>${java.version}</source>
                        <target>${java.version}</target>
                        <testSource>${java.version}</testSource>
                        <testTarget>${java.version}</testTarget>
                    </configuration>
                    <version>${maven-compiler-plugin.version}</version>
                </plugin>

                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>${maven-surefire-plugin.version}</version>
                    <configuration>
                        <skipTests>true</skipTests>  <!--默认关掉单元测试 -->
                    </configuration>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
