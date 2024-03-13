rabbitmqctl help
rabbitmqctl subcommands
rabbitmqctl subcommands help
rabbitmqadmin -urmuser -prmpassword export backup.json
exit
rabbitmqctl add_user test test
rabbitmqctl set_user_tags test administrator
rabbitmqctl set_permissions -p / test ".*" ".*" ".*"
exit
